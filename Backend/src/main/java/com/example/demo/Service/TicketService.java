package com.example.demo.Service;

import java.beans.Transient;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.TicketRepo;
import com.example.demo.Repository.CustomerRepo;
import com.example.demo.Repository.FlightRepo;
import com.example.demo.Repository.Flights_SeatRepo;
import com.example.demo.Repository.SeatRepo;

import jakarta.transaction.Transactional;

import com.example.demo.Enum.SeatStatus;
import com.example.demo.Enum.SeatType;
import com.example.demo.Enum.TicketType;
import com.example.demo.Model.*;
import com.example.demo.Repository.TripRepo;




@Service
public class TicketService {
    @Autowired
    private TripRepo tripRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private SeatRepo seatRepo;
    @Autowired
    private Flights_SeatRepo flights_seatRepo;

    @Autowired
    private FlightService flightService;
    
//    @Autowired
//    private TicketRepo ticketRepo;
//
//    public TicketService() {
//    }
//
//    public TicketService(TicketRepo ticketRepo) {
//        this.ticketRepo = ticketRepo;
//    }
//
//    public List<Ticket> getAllTicket() {
//        return ticketRepo.findAll();
//    }
//
//    public Ticket getTicketByIdTicket(int idTicket) {
//        return ticketRepo.findByIdTicket(idTicket);
//    }
//
//    public List<Ticket> getTicketByIdFlight(Flight flight) {
//        return ticketRepo.findByFlight(flight);
//    }
//
//    public List<Ticket> getTicketByIdCard(Customer customerId) {
//        return ticketRepo.findByCustomer(customerId);
//    }
//
//    public List<Ticket> getTicketByIdSeat(Seat seatId) {
//        return ticketRepo.findBySeat(seatId);
//    }
//
//    public List<Ticket> getTicketByIdFlightReturn(Flight flightReturnId) {
//        return ticketRepo.findByFlightReturn(flightReturnId);
//    }
//
//    public List<Ticket> getTicketByIdReturnFlightSeat(Seat returnFlightSeatId) {
//        return ticketRepo.findByReturnFlightSeat(returnFlightSeatId);
//    }
//
//    public List<Ticket> getTicketByBookingDay(Date bookingDay) {
//        return ticketRepo.findByBookingDay(bookingDay);
//    }
//
//    public List<Ticket> getTicketByIdBaggage(Baggage idBaggage) {
//        return ticketRepo.findByBaggage(idBaggage);
//    }
//
//    public void deleteTicket(int idTicket) {
//        ticketRepo.deleteById(idTicket);
//    }

    private boolean isAvailableSeat(List<Flights_Seat> seats, int numOfCustomer) {
        return seats.size() >= numOfCustomer;
    }
    private boolean isThisSeatAvailable(List<Flights_Seat> seats, String seatId) {
        return seats.stream().anyMatch(seat -> seat.getSeat().getSeatNumber().equals(seatId));
    }
    private boolean isTransactionValid(List<Customer> customers,  List<Flights_Seat> departureSeats, List<Flights_Seat> returnSeats, TicketType ticketType, String departureSeatId, String returnSeatId) {
       
        // kiem tra xem co du slot cho khach hang khong
        if(!isAvailableSeat(departureSeats, customers.size())) {
            throw new RuntimeException("Not enough seats available");
        }
        if(departureSeatId != null && !isThisSeatAvailable(departureSeats, departureSeatId)) {
            throw new RuntimeException("Seat not available");
        }

        if(returnSeats != null) {
            if(!isAvailableSeat(returnSeats, customers.size())) {
                throw new RuntimeException("Not enough seats available");
            }
            if(returnSeatId != null && !isThisSeatAvailable(returnSeats, returnSeatId)) {
                throw new RuntimeException("Seat not available");
            }
        }
        return true;
    }

    @Transactional
    List<Ticket> addTickets(List<Customer> customers, Integer departureFlightId, Integer returnFlightId, TicketType ticketType, String departureSeatId, String returnSeatId,Booking booking) {
        
        List<Ticket> tickets = new ArrayList<>();
        Flight departureFlight = flightRepo.findByIdFlight(departureFlightId);
        SeatType seatType = null;
        if(ticketType == TicketType.ECONOMY) {
            seatType = SeatType.ECONOMY;
        }
        else if(ticketType == TicketType.BUSINESS) {
            seatType = SeatType.BUSINESS;
        }
        List<Flights_Seat> departureSeats = flightService.getAvailbleSlot(departureFlightId, seatType);
        List<Flights_Seat> returnSeats = null;
        if(returnFlightId != null) {
            returnSeats = flightService.getAvailbleSlot(returnFlightId, seatType);
        }
        if(!isTransactionValid(customers, departureSeats, returnSeats, ticketType, departureSeatId, returnSeatId)) {
            System.out.println("Transaction not valid");
            return null;
        }

        Flight returnFlight = null;
        if(returnFlightId != null) {
            returnFlight = flightRepo.findByIdFlight(returnFlightId);
        }
        
        Flights_Seat departureSeat = null;
        Flights_Seat returnSeat = null;
        // tim kiem chon ghe
        if(departureSeatId != null && departureFlight != null) {
            departureSeat = departureFlight.getFlightsSeatList().stream()
            .filter(fs -> fs.getSeat().getSeatNumber().equals(departureSeatId))
            .findFirst()
            .orElse(null);
        }
        if(returnSeatId != null && returnFlight != null ) {
            returnSeat = returnFlight.getFlightsSeatList().stream()
            .filter(fs -> fs.getSeat().getSeatNumber().equals(returnSeatId))
            .findFirst()
            .orElse(null);
        }


        Trip trip = new Trip(departureFlight, returnFlight);
        tripRepo.save(trip);


        for (Customer customer : customers) {
            customer = customerRepo.save(customer);
            Ticket ticket = new Ticket(trip, customer, ticketType, departureSeat, returnSeat);
            tickets.add(ticket);
            long ticketPrice = 0;
            if(ticketType == TicketType.ECONOMY) {
                ticketPrice = departureFlight.getCommonFare();
                if(returnFlight != null) {
                    ticketPrice += returnFlight.getCommonFare();
                }
            }
            else if(ticketType == TicketType.BUSINESS) {
                ticketPrice = departureFlight.getVipFare();
                if(returnFlight != null) {
                    ticketPrice += returnFlight.getVipFare();
                }
            }
            ticket.setPrice(ticketPrice);
            ticket.setBooking(booking);
            ticketRepo.save(ticket);
        }

        if(departureSeat != null) {
            departureSeat.setSeatStatus(SeatStatus.BOOKED);
        }
        if(returnSeat != null) {
            returnSeat.setSeatStatus(SeatStatus.BOOKED);
        }
        return tickets;
   }
}

//    public void updateTicket(Ticket ticket) {
//        if (ticketRepo.existsById(ticket.getIdTicket())) {
//            Ticket exist = ticketRepo.findByIdTicket(ticket.getIdTicket());
//            exist.Copy(ticket);
//            ticketRepo.save(exist);
//        } else {
//            addTicket(ticket);
//        }
//    }


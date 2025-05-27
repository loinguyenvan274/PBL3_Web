package com.pbl.flightapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pbl.flightapp.Repository.TicketRepo;
import com.pbl.flightapp.Repository.UserRepo;
import com.pbl.flightapp.Repository.FlightRepo;
import com.pbl.flightapp.Repository.Flights_SeatRepo;
import com.pbl.flightapp.Repository.ReturnTicketRepo;

import jakarta.transaction.Transactional;

import com.pbl.flightapp.Enum.SeatStatus;
import com.pbl.flightapp.Enum.SeatType;
import com.pbl.flightapp.Enum.TicketType;
import com.pbl.flightapp.Model.*;
import com.pbl.flightapp.requestObj.BookingRequest;
import com.pbl.flightapp.requestObj.TicketRequest;

@Service
public class TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private Flights_SeatRepo flights_seatRepo;
    @Autowired
    private FlightService flightService;
    @Autowired
    private ReturnTicketRepo returnTicketRepo;

    // @Autowired
    // private TicketRepo ticketRepo;
    //
    // public TicketService() {
    // }
    //
    // public TicketService(TicketRepo ticketRepo) {
    // this.ticketRepo = ticketRepo;
    // }
    //
    // public List<Ticket> getAllTicket() {
    // return ticketRepo.findAll();
    // }
    //
    // public Ticket getTicketByIdTicket(int idTicket) {
    // return ticketRepo.findByIdTicket(idTicket);
    // }
    //
    // public List<Ticket> getTicketByIdFlight(Flight flight) {
    // return ticketRepo.findByFlight(flight);
    // }
    //
    // public List<Ticket> getTicketByIdCard(Customer customerId) {
    // return ticketRepo.findByCustomer(customerId);
    // }
    //
    // public List<Ticket> getTicketByIdSeat(Seat seatId) {
    // return ticketRepo.findBySeat(seatId);
    // }
    //
    // public List<Ticket> getTicketByIdFlightReturn(Flight flightReturnId) {
    // return ticketRepo.findByFlightReturn(flightReturnId);
    // }
    //
    // public List<Ticket> getTicketByIdReturnFlightSeat(Seat returnFlightSeatId) {
    // return ticketRepo.findByReturnFlightSeat(returnFlightSeatId);
    // }
    //
    // public List<Ticket> getTicketByBookingDay(Date bookingDay) {
    // return ticketRepo.findByBookingDay(bookingDay);
    // }
    //
    // public List<Ticket> getTicketByIdBaggage(Baggage idBaggage) {
    // return ticketRepo.findByBaggage(idBaggage);
    // }
    //
    // public void deleteTicket(int idTicket) {
    // ticketRepo.deleteById(idTicket);
    // }

    // todo: check if the seat is available
    private boolean isCustomerLimitExceeded(int flightId, TicketType ticketType, int numOfCustomer) {
        return flightService.getAvailableSlots(flightId, ticketType) >= numOfCustomer;
    }
    private void checkCustomerLimit(BookingRequest bookingRequest) {
        if (isCustomerLimitExceeded(bookingRequest.getDepartureFlightId(), bookingRequest.getDepartureTicketType(), bookingRequest.getTickets().size())) {
            throw new RuntimeException("Not enough seats available");
        }
        if (bookingRequest.getReturnFlightId() != null && isCustomerLimitExceeded(bookingRequest.getReturnFlightId(), bookingRequest.getReturnTicketType(), bookingRequest.getTickets().size())) {
            throw new RuntimeException("Not enough seats available");
        }

    }


    /*
     * @param requestTickets: list of tickets
     * 
     * @param departureFlightId: id of departure flight
     * 
     * @param returnFlightId: id of return flight
     * 
     * @param booking: booking
     * 
     * @return list of tickets save in db
     */
    @Transactional
    private List<Ticket> processCreateTicket(BookingRequest bookingRequest, Booking booking) {
        List<TicketRequest> requestTickets = bookingRequest.getTickets();
        Integer departureFlightId = bookingRequest.getDepartureFlightId();
        Integer returnFlightId = bookingRequest.getReturnFlightId();
        TicketType departureTicketType = bookingRequest.getDepartureTicketType();
        TicketType returnTicketType = bookingRequest.getReturnTicketType();

        List<Ticket> tickets = new ArrayList<>();
        Flight departureFlight = flightRepo.findByIdFlight(departureFlightId);
        Flight returnFlight = null;
        SeatType seatType = departureTicketType == TicketType.ECONOMY ? SeatType.ECONOMY : SeatType.BUSINESS;

        Map<String, Flights_Seat> departureSeats = flightService
                .getFlightSeats(departureFlightId, seatType, SeatStatus.NOT_BOOKED).stream()
                .collect(Collectors.toMap(seat -> seat.getSeat().getSeatNumber(), seat -> seat));
        Map<String, Flights_Seat> returnSeats = null;
        if(returnFlightId != null) {
            returnFlight = flightRepo.findByIdFlight(returnFlightId);
            returnSeats = flightService
                .getFlightSeats(returnFlightId, seatType, SeatStatus.NOT_BOOKED).stream()
                .collect(Collectors.toMap(seat -> seat.getSeat().getSeatNumber(), seat -> seat));
        }

        Flights_Seat departureSeat = null;
        ReturnTicket returnTicket = null;
        for (TicketRequest ticketRequest : requestTickets) {
            departureSeat = null;
            returnTicket = null;
            if (ticketRequest.getSeatId() != null) {
                departureSeat = departureSeats.get(ticketRequest.getSeatId());
                if(departureSeat == null) {
                    throw new RuntimeException("Seat not available");
                }
                departureSeat.setSeatStatus(SeatStatus.BOOKED);
            }
            if(ticketRequest.getReturnTicket() != null) {
                Flights_Seat returnSeat = null;
                if(ticketRequest.getReturnTicket().getSeatId() != null) {
                    returnSeat = returnSeats.get(ticketRequest.getReturnTicket().getSeatId());
                    if(returnSeat == null) {
                        throw new RuntimeException("Seat not available");
                    }
                    returnSeat.setSeatStatus(SeatStatus.BOOKED);
                }
                returnTicket = new ReturnTicket(null, returnFlight, returnTicketType, returnSeat);
                returnTicketRepo.save(returnTicket);    
            }

            User user = ticketRequest.getUser();
            user = userRepo.save(user);

            Ticket ticket = new Ticket(user, departureFlight, departureTicketType, departureSeat, returnTicket);
            if(returnTicket != null) {
                returnTicket.setTicket(ticket);
            }
            ticket.setBooking(booking);
            ticket.setPrice(departureFlight.getPrice(departureTicketType));
            ticketRepo.save(ticket);
            tickets.add(ticket);
        }
        return tickets;
    }

    List<Ticket> addTickets(BookingRequest bookingRequest, Booking booking) {
        // bước kiểm tra
        try {
            checkCustomerLimit(bookingRequest);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
        // bước thực hiện
        // 注意： departureSeatId は seatNumber である
        return processCreateTicket(bookingRequest, booking);
    }
}

// public void updateTicket(Ticket ticket) {
// if (ticketRepo.existsById(ticket.getIdTicket())) {
// Ticket exist = ticketRepo.findByIdTicket(ticket.getIdTicket());
// exist.Copy(ticket);
// ticketRepo.save(exist);
// } else {
// addTicket(ticket);
// }
// }

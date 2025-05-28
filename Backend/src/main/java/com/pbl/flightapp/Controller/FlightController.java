package com.pbl.flightapp.Controller;

import com.pbl.flightapp.DTO.FlightDTO;
import com.pbl.flightapp.DTO.FlightSeatDTO;
import com.pbl.flightapp.DTO.UserDTO;
import com.pbl.flightapp.Enum.SeatType;
import com.pbl.flightapp.Enum.TicketType;
import com.pbl.flightapp.Model.Flight;
import com.pbl.flightapp.Model.Flights_Seat;
import com.pbl.flightapp.Model.Location;
import com.pbl.flightapp.Model.Ticket;
import com.pbl.flightapp.Repository.LocationRepo;
import com.pbl.flightapp.Service.FlightService;
import com.pbl.flightapp.Service.Flights_SeatService;
import com.pbl.flightapp.appExc.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private LocationRepo locationRepo;

    @Autowired
    private Flights_SeatService flights_seatService;

    ///
    // Thêm chuyến bay mới
    @PostMapping("")
    public void addFlight(@RequestBody Flight flight) {
        flightService.addFlight(flight);
    }

    // Cập nhật chuyến bay (nếu có thì update, không có thì tạo mới)
    @PutMapping("/{id}")
    public void updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        flight.setIdFlight(id);
        flightService.updateFlight(flight);
    }

    // Xoá chuyến bay
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
    }

    @GetMapping("/{idFlight}")
    public Flight findFlightById(@PathVariable int idFlight) {
        return flightService.getFlightById(idFlight);
    }

    @GetMapping("/{idFlight}/information")
    public Map<String, Object> getFlightInformation(@PathVariable int idFlight) {
        Map<String, Object> flightInformation = new HashMap<>();
        FlightDTO flight = flightService.getFlightDTO(idFlight);
        if (flight == null) {
            throw new NotFoundException("Flight not found", "FLIGHT_NOT_FOUND");
        }
        flightInformation.put("flight", flight);
        List<Map<String, Object>> bookedTickets = new ArrayList<>();
        for(Ticket ticket : flightService.getBookedTickets(idFlight, null)){
            Map<String, Object> ticketInformation = new HashMap<>();
            ticketInformation.put("Customer", new UserDTO(ticket.getUser()));
            ticketInformation.put("ticketType", ticket.getTicketType());
            if(ticket.getReturnTicket() != null && ticket.getReturnTicket().getFlight().getIdFlight() == idFlight){
                ticketInformation.put("ticketType", ticket.getReturnTicket().getTicketType());
            }
            bookedTickets.add(ticketInformation);
        }
        flightInformation.put("bookedTickets", bookedTickets);
        flightInformation.put("economySeatNumber", flightService.getFlightSeats(idFlight, SeatType.ECONOMY, null).size());
        flightInformation.put("businessSeatNumber", flightService.getFlightSeats(idFlight, SeatType.BUSINESS, null).size());
        return flightInformation;
    }

    @GetMapping("/find_flight")
    public List<Flight> searchFlights(
            @RequestParam int fromLocationId,
            @RequestParam int toLocationId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {

        Location from = locationRepo.findById(fromLocationId).orElseThrow();
        Location to = locationRepo.findById(toLocationId).orElseThrow();
        return flightService.getFlightByFromAndToAndDepartureDate(from, to, java.sql.Date.valueOf(departureDate));
    }

    // Lấy toàn bộ chuyến bay
    @GetMapping("/all_flights")
    public List<Flight> allFlights() {
        return flightService.getAllFlight();
    }

    @GetMapping("/flight_seats")
    public List<FlightSeatDTO> getFlightSeats(@RequestParam int flightId) {
        return flights_seatService.getFlightSeatsByIdFlight(flightId);
    }

}

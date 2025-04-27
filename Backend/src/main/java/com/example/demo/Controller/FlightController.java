package com.example.demo.Controller;

import com.example.demo.Model.Location;
import com.example.demo.Repository.LocationRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import com.example.demo.Model.Flight;
import com.example.demo.Service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @Autowired
    LocationRepo locationRepo;

    public FlightController(FlightService fService) {
        this.flightService = fService;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/find_flight_by_id/{idFlight}")
    public Flight findFlightById(@PathVariable int idFlight) {
        return flightService.getFlightById(idFlight);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/find_flight")
    public List<Flight> searchFlights(
            @RequestParam int fromLocationId,
            @RequestParam int toLocationId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate) {

        Location from = locationRepo.findById(fromLocationId).orElseThrow();
        Location to = locationRepo.findById(toLocationId).orElseThrow();
        return flightService.getFlightByFromAndToAndDepartureDate(from, to, java.sql.Date.valueOf(departureDate));
    }
}

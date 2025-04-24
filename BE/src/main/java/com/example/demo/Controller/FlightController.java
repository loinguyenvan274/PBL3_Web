package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import com.example.demo.Model.Flight;
import com.example.demo.Service.FlightService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService fService) {
        this.flightService = fService;
    }

    @GetMapping("/find_flight_by_id/{idFlight}")
    public Flight findFlightById(@PathVariable int idFlight) {
        return flightService.getFlightById(idFlight);
    }

    @GetMapping("/find_flight")
    public List<Flight> findFlight(@RequestParam String fromLocation, @RequestParam String toLocation,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate) {
        return flightService.getFlightByFromAndToAndDepartureDate(fromLocation, toLocation,
                Date.valueOf(departureDate));
    }

}

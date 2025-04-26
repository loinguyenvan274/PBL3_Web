package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;
import com.example.demo.Model.Flight;
import com.example.demo.Service.FlightService;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    public FlightController(FlightService fService) {
        this.flightService = fService;
    }

    @GetMapping("/find_flight_by_id/{idFlight}")
    public Flight findFlightById(@PathVariable int idFlight) {
        return flightService.getFlightById(idFlight);
    }

    @GetMapping("/find_flight")
    // http://localhost:8080/flight/find_flight?fromLocation=HN&toLocation=HP&departureDate=2025-01-01
    public ResponseEntity<?> findFlight(@RequestParam String fromLocation, @RequestParam String toLocation,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate, HttpSession session) {
        // ********* Check session *********
        if (session.getAttribute("Role") != "user" ||
                session.getAttribute("username") == null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", "/login");
            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }
        return ResponseEntity.ok(flightService.getFlightByFromAndToAndDepartureDate(fromLocation, toLocation,
                Date.valueOf(departureDate)));

    }

}

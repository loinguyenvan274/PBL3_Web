package com.example.demo.Service;

import com.example.demo.Model.Flight;
import com.example.demo.Repository.FlightRepo;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private FlightRepo flightRepo;

    @Autowired
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public Flight getFlightById(int idFlight) {
        return flightRepo.findByIdFlight(idFlight);
    }

    public List<Flight> getFlightByFromAndTo(String fromLocation, String toLocation) {
        return flightRepo.findByFromLocationAndToLocation(fromLocation, toLocation);
    }

    public List<Flight> getFlightByFromAndToAndDepartureDate(String fromLocation, String toLocation,
            Date departureDate) {
        return flightRepo.findByFromLocationAndToLocationAndDepartureDate(fromLocation, toLocation, departureDate);
    }
}

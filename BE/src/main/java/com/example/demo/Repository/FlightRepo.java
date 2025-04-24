package com.example.demo.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {
    Flight findByIdFlight(int idFlight);

    List<Flight> findByFromLocationAndToLocation(String fromLocation, String toLocation);

    List<Flight> findByFromLocationAndToLocationAndDepartureDate(String fromLocation, String toLocation,
            Date departureDate);
}

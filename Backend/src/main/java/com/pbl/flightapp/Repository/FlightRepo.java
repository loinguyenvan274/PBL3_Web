package com.pbl.flightapp.Repository;

import java.sql.Date;
import java.util.List;

import com.pbl.flightapp.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pbl.flightapp.Model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {
    Flight findByIdFlight(int idFlight);

//    List<Flight> findByFromLocationAndToLocation(Location fromLocation, Location toLocation);

    List<Flight> findByFromLocationAndToLocationAndDepartureDate(Location fromLocation, Location toLocation,
                                                                 Date departureDate);
}

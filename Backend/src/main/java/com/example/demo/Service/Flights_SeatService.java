package com.example.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.Repository.Flights_SeatRepo;
import com.example.demo.Model.Flights_Seat;
import java.util.List;

@Service
public class Flights_SeatService {
    @Autowired
    private Flights_SeatRepo flight_seatRepo;

    // public Flights_SeatService(Flights_SeatRepo flight_seatRepo) {
    // this.flight_seatRepo = flight_seatRepo;
    // }

    public List<Flights_Seat> getAllFlight_Seat() {
        return flight_seatRepo.findAll();
    }

    public Flights_Seat getByIdFlightsAndIdSeat(int flightId, int seatId) {
        return flight_seatRepo.findByIdFlightAndIdSeat(flightId, seatId);
    }

    public List<Flights_Seat> getFlights_SeatByFlightId(int flightId) {
        return flight_seatRepo.findByIdFlight(flightId);
    }

}

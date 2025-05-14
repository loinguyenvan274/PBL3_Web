package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Flight;
import com.example.demo.Model.Trip;

import java.util.Date;

public interface TripRepo extends JpaRepository<Trip, Integer> {
//    Trip findByIdTrip(int idTrip);
//    Trip findByDepartureFlightAndReturnFlight(Flight departureFlight, Flight returnFlight);
//    Trip findByBookingDay(Date bookingDay);
//    Trip findByBookingDayAndDepartureFlight(Date bookingDay, Flight departureFlight);
//    Trip findByBookingDayAndReturnFlight(Date bookingDay, Flight returnFlight);
}

package com.pbl.flightapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pbl.flightapp.Model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{
}

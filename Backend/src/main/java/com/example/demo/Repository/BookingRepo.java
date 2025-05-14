package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{
}

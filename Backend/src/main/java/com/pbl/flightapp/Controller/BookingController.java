package com.pbl.flightapp.Controller;


import com.pbl.flightapp.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pbl.flightapp.Service.BookingService;
import com.pbl.flightapp.requestObj.BookingRequest;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    // @PutMapping("/{id}")
    // public Booking updateBooking(@PathVariable int id, @RequestBody BookingRequest bookingRequest) {
    //     return bookingService.updateBooking(id, bookingRequest);
    // }
    // 予約を作成する
    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }

    @GetMapping("/{id}")
    public Booking getBooking(@PathVariable int id){
        try {
            return bookingService.getBooking(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id){
        bookingService.deleteBooking(id);
    }

}
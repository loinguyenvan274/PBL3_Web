package com.pbl.flightapp.Controller;


import com.pbl.flightapp.Model.Booking;

import java.util.List;
import java.util.Map;
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
import com.pbl.flightapp.DTO.BookingDTO;
import java.util.HashMap;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
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
    @GetMapping("findByCustomerId/{customerId}")
    public List<BookingDTO> findByCustomerId(@PathVariable int customerId){
        return bookingService.findByCustomerId(customerId);
    }
    @GetMapping("/fromDate/{fromDate}/toDate/{toDate}")
    public List<BookingDTO> findByFromDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate toDate) {
        return bookingService.findByFromDate(fromDate, toDate);
    }
    
}
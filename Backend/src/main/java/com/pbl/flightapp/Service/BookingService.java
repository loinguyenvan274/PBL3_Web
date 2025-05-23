package com.pbl.flightapp.Service;

import java.util.List;

import com.pbl.flightapp.Repository.CustomerRepo;
import com.pbl.flightapp.requestObj.BookingRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.pbl.flightapp.Model.Booking;
import com.pbl.flightapp.Model.Customer;
import com.pbl.flightapp.Model.Ticket;
import com.pbl.flightapp.Repository.BookingRepo;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private CustomerRepo customerRepo;


    // @Transactional
    // public Booking updateBooking(int id, BookingRequest bookingRequest) {
    //     Booking booking = bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        

    //     List<Ticket> tickets = updateBooking.getTickets();
    //     for(Ticket ticket : tickets) {
    //         ticket.setBooking(booking);
    //     }
    //     booking.setPaymentMethod(updateBooking.getPaymentMethod());
    //     return bookingRepo.save(booking);
    // }

    // 予約を作成する
    @Transactional
    public Booking createBooking(BookingRequest bookingRequest) {
        if(bookingRequest.getTickets().isEmpty()) {
            throw new RuntimeException("Tickets are required");
        }

        Booking booking = new Booking();
        booking.setPaymentMethod(bookingRequest.getPaymentMethod());
        
        // Set the first customer as the booking customer
        Customer bookingCustomer = bookingRequest.getTickets().getFirst().getCustomer();
        bookingCustomer = customerRepo.save(bookingCustomer);
        booking.setCustomer(bookingCustomer);
        booking = bookingRepo.save(booking);

        List<Ticket> createdTickets = ticketService.addTickets(bookingRequest, booking);

        booking.setTickets(createdTickets);
        long totalPrice = 0;
        for(Ticket ticket : createdTickets) {
            totalPrice += ticket.getPrice();
        }
        booking.setAmount(totalPrice);
        return booking;
    }

    public Booking getBooking(int id) throws Exception {
        return bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public void deleteBooking(int id) {
        bookingRepo.deleteById(id);
    }
    
    
}

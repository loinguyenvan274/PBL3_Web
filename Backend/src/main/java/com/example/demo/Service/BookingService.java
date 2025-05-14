package com.example.demo.Service;

import java.util.List;

import com.example.demo.Repository.CustomerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Enum.PaymentMethod;
import com.example.demo.Enum.TicketType;
import com.example.demo.Model.Booking;
import com.example.demo.Model.Customer;
import com.example.demo.Model.Ticket;
import com.example.demo.Repository.BookingRepo;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private CustomerRepo customerRepo;

    @Transactional
    public Booking createBooking(PaymentMethod paymentMethod, List<Customer> customers, Integer departureFlightId, Integer returnFlightId, TicketType ticketType, String departureSeatId, String returnSeatId) {

        if(customers.isEmpty()) {
            throw new RuntimeException("Customers are required");
        }

        Booking booking = new Booking();
        booking.setPaymentMethod(paymentMethod);
        Customer bookingCustomer = customers.getFirst();
        bookingCustomer =  customerRepo.save(bookingCustomer);
        booking.setCustomer(customers.getFirst());
        booking = bookingRepo.save(booking);

        List<Ticket> tickets = ticketService.addTickets(customers, departureFlightId, returnFlightId, ticketType, departureSeatId, returnSeatId,booking);

        booking.setTickets(tickets);
        long totalPrice = 0;
        for(Ticket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }
        booking.setAmount(totalPrice);
        return booking;
    }
    
    
}

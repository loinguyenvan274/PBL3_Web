package com.example.demo.Controller;

import com.example.demo.Enum.PaymentMethod;
import com.example.demo.Enum.TicketType;
import com.example.demo.Model.Booking;
import com.example.demo.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(
                request.getPaymentMethod(),
                request.getCustomers(),
                request.getDepartureFlightId(),
                request.getReturnFlightId(),
                request.getTicketType(),
                request.getDepartureSeatId(),
                request.getReturnSeatId());
    }

    public static class BookingRequest {
        private PaymentMethod paymentMethod;
        private List<Customer> customers;
        private Integer departureFlightId;
        private Integer returnFlightId;
        private TicketType ticketType;
        private String departureSeatId;
        private String returnSeatId;

        public PaymentMethod getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public List<Customer> getCustomers() {
            return customers;
        }

        public void setCustomers(List<Customer> customers) {
            this.customers = customers;
        }

        public Integer getDepartureFlightId() {
            return departureFlightId;
        }

        public void setDepartureFlightId(Integer departureFlightId) {
            this.departureFlightId = departureFlightId;
        }

        public Integer getReturnFlightId() {
            return returnFlightId;
        }

        public void setReturnFlightId(Integer returnFlightId) {
            this.returnFlightId = returnFlightId;
        }

        public TicketType getTicketType() {
            return ticketType;
        }

        public void setTicketType(TicketType ticketType) {
            this.ticketType = ticketType;
        }

        public String getDepartureSeatId() {
            return departureSeatId;
        }

        public void setDepartureSeatId(String departureSeatId) {
            this.departureSeatId = departureSeatId;
        }

        public String getReturnSeatId() {
            return returnSeatId;
        }

        public void setReturnSeatId(String returnSeatId) {
            this.returnSeatId = returnSeatId;
        }
    }

}
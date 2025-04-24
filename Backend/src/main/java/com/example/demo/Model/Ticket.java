package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTicket;

    @ManyToOne
    @JoinColumn(name = "Id_Flight", referencedColumnName = "Id_Flight", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "Id_Flight_Return", referencedColumnName = "Id_Flight", nullable = true)
    private Flight flightReturn;

    @ManyToOne
    @JoinColumn(name = "Id_Card", referencedColumnName = "Id_Card", nullable = false)
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "Id_Seat", referencedColumnName = "Id_Seat", nullable = false)
    private Seat seat;

    @OneToOne
    @JoinColumn(name = "Id_Seat_Return", referencedColumnName = "Id_Seat", nullable = true)
    private Seat returnFlightSeat;

    private String ticketPrice;
    private Date bookingDay;

    @OneToOne
    @JoinColumn(name = "Id_Baggage", referencedColumnName = "Id_Baggage", nullable = true)
    private Baggage baggage;

    private Timestamp createdAt;

    public Ticket() {
    }

    public Ticket(int idTicket, Flight flight, Flight flightReturn, Customer customer,
            Seat seat, Seat returnFlightSeat, String ticketPrice,
            Date bookingDay, Baggage baggage) {
        this.idTicket = idTicket;
        this.flight = flight;
        this.flightReturn = flightReturn;
        this.customer = customer;
        this.seat = seat;
        this.returnFlightSeat = returnFlightSeat;
        this.ticketPrice = ticketPrice;
        this.bookingDay = bookingDay;
        this.baggage = baggage;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public int getKey() {
        return idTicket;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(String.valueOf(flight != null ? flight.getIdFlight() : "null"));
        value.add(String.valueOf(flightReturn != null ? flightReturn.getIdFlight() : "null"));
        value.add(String.valueOf(customer != null ? customer.getIdCard() : "null"));
        value.add(String.valueOf(seat != null ? seat.getIdSeat() : "null"));
        value.add(String.valueOf(returnFlightSeat != null ? returnFlightSeat.getIdSeat() : "null"));
        value.add(ticketPrice);
        value.add(bookingDay.toString());
        value.add(String.valueOf(baggage != null ? baggage.getIdBaggage() : "null"));
        return value;
    }

    // Getters and Setters

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlightReturn() {
        return flightReturn;
    }

    public void setFlightReturn(Flight flightReturn) {
        this.flightReturn = flightReturn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Seat getReturnFlightSeat() {
        return returnFlightSeat;
    }

    public void setReturnFlightSeat(Seat returnFlightSeat) {
        this.returnFlightSeat = returnFlightSeat;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getBookingDay() {
        return bookingDay.toString();
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = Date.valueOf(bookingDay);
    }

    public Baggage getBaggage() {
        return baggage;
    }

    public void setBaggage(Baggage baggage) {
        this.baggage = baggage;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", flight=" + flight +
                ", flightReturn=" + flightReturn +
                ", customer=" + customer +
                ", seat=" + seat +
                ", returnFlightSeat=" + returnFlightSeat +
                ", ticketPrice='" + ticketPrice + '\'' +
                ", bookingDay='" + bookingDay + '\'' +
                ", baggage=" + baggage +
                ", createdAt=" + createdAt +
                '}';
    }

    public void Copy(Ticket ticket) {
        this.flight = ticket.getFlight();
        this.flightReturn = ticket.getFlightReturn();
        this.customer = ticket.getCustomer();
        this.seat = ticket.getSeat();
        this.returnFlightSeat = ticket.getReturnFlightSeat();
        this.ticketPrice = ticket.getTicketPrice();
        this.bookingDay = Date.valueOf(ticket.getBookingDay());
        this.baggage = ticket.getBaggage();
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}

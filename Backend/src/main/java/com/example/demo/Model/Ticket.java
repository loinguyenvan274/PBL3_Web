package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idTicket")
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
    @JoinColumn(name = "id_customer", referencedColumnName = "Id_Card", nullable = false)
    private Customer customer;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "departure_flight_id", referencedColumnName = "id_flight"),
            @JoinColumn(name = "departure_id_seat", referencedColumnName = "id_seat")
    })
    private Flights_Seat departureSeat;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "return_flight_id", referencedColumnName = "id_flight"),
            @JoinColumn(name = "return_id_seat", referencedColumnName = "id_seat")
    })
    private Flights_Seat returnSeat;

    @Column(name = "price")
    private Long price;

    @Column(name = "booking_day")
    private Date bookingDay;

    @OneToOne
    @JoinColumn(name = "Id_Baggage", referencedColumnName = "Id_Baggage", nullable = true)
    private Baggage baggage;

    private Timestamp createdAt;

    public Ticket() {
    }

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

    public Flights_Seat getDepartureSeat() {
        return departureSeat;
    }

    public void setDepartureSeat(Flights_Seat departureSeat) {
        this.departureSeat = departureSeat;
    }

    public Flights_Seat getReturnSeat() {
        return returnSeat;
    }

    public void setReturnSeat(Flights_Seat returnSeat) {
        this.returnSeat = returnSeat;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(Date bookingDay) {
        this.bookingDay = bookingDay;
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
    public boolean equals(Object o) {
        if (!(o instanceof Ticket ticket)) return false;
        return idTicket == ticket.idTicket;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idTicket);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", flight=" + flight +
                ", flightReturn=" + flightReturn +
                ", customer=" + customer +
                ", departureSeat=" + departureSeat +
                ", returnSeat=" + returnSeat +
                ", price=" + price +
                ", bookingDay=" + bookingDay +
                ", baggage=" + baggage +
                ", createdAt=" + createdAt +
                '}';
    }
}

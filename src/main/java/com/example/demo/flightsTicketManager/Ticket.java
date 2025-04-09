package com.example.demo.flightsTicketManager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private String Id_Ticket;
    private String Id_Flight;
    private String Id_Flight_Return;
    private String Id_Card;
    private String Id_Seat;
    private String Id_Return_Flight_Seat;
    private String Ticket_Price;
    private String Booking_Day;
    private String Id_Baggage;
    private Timestamp created_at;

    public Ticket() {
    }

    public Ticket(String Id_Ticket, String Id_Flight, String Id_Flight_Return, String Id_Card, String Id_Seat,
            String Id_Return_Flight_Seat, String Ticket_Price, String Booking_Day, String Id_Baggage,
            Timestamp created_at) {
        this.Id_Ticket = Id_Ticket;
        this.Id_Flight = Id_Flight;
        this.Id_Flight_Return = Id_Flight_Return;
        this.Id_Card = Id_Card;
        this.Id_Seat = Id_Seat;
        this.Id_Return_Flight_Seat = Id_Return_Flight_Seat;
        this.Ticket_Price = Ticket_Price;
        this.Booking_Day = Booking_Day;
        this.Id_Baggage = Id_Baggage;
        this.created_at = created_at;
    }

    public String getKey() {
        return Id_Ticket;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(Id_Flight);
        value.add(Id_Flight_Return);
        value.add(Id_Card);
        value.add(Id_Seat);
        value.add(Id_Return_Flight_Seat);
        value.add(Ticket_Price);
        value.add(Booking_Day);
        value.add(Id_Baggage);
        return value;
    }

    public String getId_Ticket() {
        return Id_Ticket;
    }

    public void setId_Ticket(String Id_Ticket) {
        this.Id_Ticket = Id_Ticket;
    }

    public String getId_Flight() {
        return Id_Flight;
    }

    public void setId_Flight(String Id_Flight) {
        this.Id_Flight = Id_Flight;
    }

    public String getId_Flight_Return() {
        return Id_Flight_Return;
    }

    public void setId_Flight_Return(String Id_Flight_Return) {
        this.Id_Flight_Return = Id_Flight_Return;
    }

    public String getId_Card() {
        return Id_Card;
    }

    public void setId_Card(String Id_Card) {
        this.Id_Card = Id_Card;
    }

    public String getId_Seat() {
        return Id_Seat;
    }

    public void setId_Seat(String Id_Seat) {
        this.Id_Seat = Id_Seat;
    }

    public String getId_Return_Flight_Seat() {
        return Id_Return_Flight_Seat;
    }

    public void setId_Return_Flight_Seat(String Id_Return_Flight_Seat) {
        this.Id_Return_Flight_Seat = Id_Return_Flight_Seat;
    }

    public String getTicket_Price() {
        return Ticket_Price;
    }

    public void setTicket_Price(String Ticket_Price) {
        this.Ticket_Price = Ticket_Price;
    }

    public String getBooking_Day() {
        return Booking_Day;
    }

    public void setBooking_Day(String Booking_Day) {
        this.Booking_Day = Booking_Day;
    }

    public String getId_Baggage() {
        return Id_Baggage;
    }

    public void setId_Baggage(String Id_Baggage) {
        this.Id_Baggage = Id_Baggage;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Id_Ticket='" + Id_Ticket + '\'' +
                ", Id_Flight='" + Id_Flight + '\'' +
                ", Id_Flight_Return='" + Id_Flight_Return + '\'' +
                ", Id_Card='" + Id_Card + '\'' +
                ", Id_Seat='" + Id_Seat + '\'' +
                ", Id_Return_Flight_Seat='" + Id_Return_Flight_Seat + '\'' +
                ", Ticket_Price='" + Ticket_Price + '\'' +
                ", Booking_Day='" + Booking_Day + '\'' +
                ", Id_Baggage='" + Id_Baggage + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}

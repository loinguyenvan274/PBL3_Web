package com.example.demo.flightsTicketManager;

import java.sql.Timestamp;

public class Ticket {
    private String idTicket;
    private String idFlight;
    private String idFlightReturn;
    private String idCard;
    private String idSeat;
    private String idReturnFlightSeat;
    private String ticketPrice;
    private String bookingDay;
    private String idBaggage;
    private Timestamp createdAt;

    public Ticket() {
    }

    public Ticket(String idTicket, String idFlight, String idFlightReturn, String idCard, String idSeat,
            String idReturnFlightSeat, String ticketPrice, String bookingDay, String idBaggage, Timestamp createdAt) {
        this.idTicket = idTicket;
        this.idFlight = idFlight;
        this.idFlightReturn = idFlightReturn;
        this.idCard = idCard;
        this.idSeat = idSeat;
        this.idReturnFlightSeat = idReturnFlightSeat;
        this.ticketPrice = ticketPrice;
        this.bookingDay = bookingDay;
        this.idBaggage = idBaggage;
        this.createdAt = createdAt;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(String idFlight) {
        this.idFlight = idFlight;
    }

    public String getIdFlightReturn() {
        return idFlightReturn;
    }

    public void setIdFlightReturn(String idFlightReturn) {
        this.idFlightReturn = idFlightReturn;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(String idSeat) {
        this.idSeat = idSeat;
    }

    public String getIdReturnFlightSeat() {
        return idReturnFlightSeat;
    }

    public void setIdReturnFlightSeat(String idReturnFlightSeat) {
        this.idReturnFlightSeat = idReturnFlightSeat;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getBookingDay() {
        return bookingDay;
    }

    public void setBookingDay(String bookingDay) {
        this.bookingDay = bookingDay;
    }

    public String getIdBaggage() {
        return idBaggage;
    }

    public void setIdBaggage(String idBaggage) {
        this.idBaggage = idBaggage;
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
                "idTicket='" + idTicket + '\'' +
                ", idFlight='" + idFlight + '\'' +
                ", idFlightReturn='" + idFlightReturn + '\'' +
                ", idCard='" + idCard + '\'' +
                ", idSeat='" + idSeat + '\'' +
                ", idReturnFlightSeat='" + idReturnFlightSeat + '\'' +
                ", ticketPrice='" + ticketPrice + '\'' +
                ", bookingDay='" + bookingDay + '\'' +
                ", idBaggage='" + idBaggage + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

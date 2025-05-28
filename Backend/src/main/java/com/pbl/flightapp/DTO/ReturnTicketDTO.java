package com.pbl.flightapp.DTO;

import com.pbl.flightapp.Model.ReturnTicket;

public class ReturnTicketDTO {
    private int idReturnTicket;
    private int ticketId;
    private int flightId;
    private String ticketType;
    private int flightSeatId;
    private int seatFlightId;
    private Long price;
    private int baggageId;

    public ReturnTicketDTO() {
    }

    public ReturnTicketDTO(int idReturnTicket, int ticketId, int flightId, String ticketType, 
                       int flightSeatId, int seatFlightId, Long price, int baggageId) {
        this.idReturnTicket = idReturnTicket;
        this.ticketId = ticketId;
        this.flightId = flightId;
        this.ticketType = ticketType;
        this.flightSeatId = flightSeatId;
        this.seatFlightId = seatFlightId;
        this.price = price;
        this.baggageId = baggageId;
    }
    public ReturnTicketDTO(ReturnTicket returnTicket) {
        this.idReturnTicket = returnTicket.getIdReturnTicket();
        this.ticketId = returnTicket.getTicket().getIdTicket();
        this.flightId = returnTicket.getFlight().getIdFlight();
        this.ticketType = returnTicket.getTicketType().toString();
        this.price = returnTicket.getPrice();
    }

    public int getIdReturnTicket() {
        return idReturnTicket;
    }

    public void setIdReturnTicket(int idReturnTicket) {
        this.idReturnTicket = idReturnTicket;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getFlightSeatId() {
        return flightSeatId;
    }

    public void setFlightSeatId(int flightSeatId) {
        this.flightSeatId = flightSeatId;
    }

    public int getSeatFlightId() {
        return seatFlightId;
    }

    public void setSeatFlightId(int seatFlightId) {
        this.seatFlightId = seatFlightId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getBaggageId() {
        return baggageId;
    }

    public void setBaggageId(int baggageId) {
        this.baggageId = baggageId;
    }
}

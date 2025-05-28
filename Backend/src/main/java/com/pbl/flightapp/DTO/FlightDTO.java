package com.pbl.flightapp.DTO;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.pbl.flightapp.Model.Flight;

public class FlightDTO {
    private int idFlight;
    private int planeId;
    private Date departureDate;
    private Time departureTime; 
    private Long durationMinutes;
    private Long commonFare;
    private Long vipFare;
    private int fromLocationId;
    private int toLocationId;
    private Timestamp createdAt;
    private int bookedEconomyCustomerNumber;
    private int bookedVipCustomerNumber;
    private int economySeats;
    private int vipSeats;
    

    public FlightDTO() {
    }
    public FlightDTO(int idFlight, int planeId, Date departureDate, Time departureTime, Long durationMinutes, Long commonFare, Long vipFare, int fromLocationId, int toLocationId, Timestamp createdAt, int bookedEconomyCustomerNumber, int bookedVipCustomerNumber, int economySeats, int vipSeats) {
        this.idFlight = idFlight;
        this.planeId = planeId;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.durationMinutes = durationMinutes;
        this.commonFare = commonFare;
        this.vipFare = vipFare;
        this.fromLocationId = fromLocationId;
        this.toLocationId = toLocationId;
        this.createdAt = createdAt;
        this.bookedEconomyCustomerNumber = bookedEconomyCustomerNumber;
        this.bookedVipCustomerNumber = bookedVipCustomerNumber;
        this.economySeats = economySeats;
        this.vipSeats = vipSeats;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public int getBookedEconomyCustomerNumber() {
        return bookedEconomyCustomerNumber;
    }

    public void setBookedEconomyCustomerNumber(int bookedEconomyCustomerNumber) {
        this.bookedEconomyCustomerNumber = bookedEconomyCustomerNumber;
    }   

    public int getBookedVipCustomerNumber() {
        return bookedVipCustomerNumber;
    }

    public void setBookedVipCustomerNumber(int bookedVipCustomerNumber) {
        this.bookedVipCustomerNumber = bookedVipCustomerNumber;
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    public int getVipSeats() {
        return vipSeats;
    }

    public void setVipSeats(int vipSeats) {
        this.vipSeats = vipSeats;
    }
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Long getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Long durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Long getCommonFare() {
        return commonFare;
    }

    public void setCommonFare(Long commonFare) {
        this.commonFare = commonFare;
    }

    public Long getVipFare() {
        return vipFare;
    }

    public void setVipFare(Long vipFare) {
        this.vipFare = vipFare;
    }

    public int getFromLocationId() {
        return fromLocationId;
    }

    public void setFromLocationId(int fromLocationId) {
        this.fromLocationId = fromLocationId;
    }

    public int getToLocationId() {
        return toLocationId;
    }

    public void setToLocationId(int toLocationId) {
        this.toLocationId = toLocationId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public void copyFrom(Flight flight) {
        this.idFlight = flight.getIdFlight();
        this.planeId = flight.getPlane().getIdPlane();
        this.departureDate = flight.getDepartureDate();
        this.departureTime = flight.getDepartureTime();
        this.durationMinutes = flight.getDurationMinutes();
        this.commonFare = flight.getCommonFare();
        this.vipFare = flight.getVipFare();
        this.fromLocationId = flight.getFromLocation().getId();
        this.toLocationId = flight.getToLocation().getId();
        this.createdAt = flight.getCreatedAt();
    }
}

package com.example.demo.flightsTicketManager;

import java.sql.Timestamp;

public class Flight {
    private String idFlight;
    private String idPlane;
    private String idArea;
    private int seatCount;
    private int currentSeat;
    private String departureDay;
    private String departureTime;
    private String estimatedArrivalDay;
    private String estimatedArrivalTime;
    private String from;
    private String to;
    private Timestamp createdAt;

    public Flight() {
    }

    public Flight(String idFlight, String idPlane, String idArea, int seatCount, int currentSeat,
            String departureDay, String departureTime, String estimatedArrivalDay, String estimatedArrivalTime,
            String from, String to, Timestamp createdAt) {
        this.idFlight = idFlight;
        this.idPlane = idPlane;
        this.idArea = idArea;
        this.seatCount = seatCount;
        this.currentSeat = currentSeat;
        this.departureDay = departureDay;
        this.departureTime = departureTime;
        this.estimatedArrivalDay = estimatedArrivalDay;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.from = from;
        this.to = to;
        this.createdAt = createdAt;
    }

    public String getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(String idFlight) {
        this.idFlight = idFlight;
    }

    public String getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(String idPlane) {
        this.idPlane = idPlane;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getCurrentSeat() {
        return currentSeat;
    }

    public void setCurrentSeat(int currentSeat) {
        this.currentSeat = currentSeat;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getEstimatedArrivalDay() {
        return estimatedArrivalDay;
    }

    public void setEstimatedArrivalDay(String estimatedArrivalDay) {
        this.estimatedArrivalDay = estimatedArrivalDay;
    }

    public String getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(String estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "idFlight='" + idFlight + '\'' +
                ", idPlane='" + idPlane + '\'' +
                ", idArea='" + idArea + '\'' +
                ", seatCount=" + seatCount +
                ", currentSeat=" + currentSeat +
                ", departureDay='" + departureDay + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", estimatedArrivalDay='" + estimatedArrivalDay + '\'' +
                ", estimatedArrivalTime='" + estimatedArrivalTime + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

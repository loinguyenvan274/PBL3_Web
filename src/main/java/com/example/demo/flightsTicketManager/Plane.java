package com.example.demo.flightsTicketManager;

public class Plane {
    public enum Status {
        MAINTENANCE, NORMAL
    }

    private String idPlane;
    private String idArea;
    private String namePlane;
    private Status status;
    private int flightHours;
    private int seatCount;

    public Plane() {
    }

    public Plane(String idPlane, String idArea, String namePlane, Status status, int flightHours, int seatCount) {
        this.idPlane = idPlane;
        this.idArea = idArea;
        this.namePlane = namePlane;
        this.status = status;
        this.flightHours = flightHours;
        this.seatCount = seatCount;
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

    public String getNamePlane() {
        return namePlane;
    }

    public void setNamePlane(String namePlane) {
        this.namePlane = namePlane;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(int flightHours) {
        this.flightHours = flightHours;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "idPlane='" + idPlane + '\'' +
                ", idArea='" + idArea + '\'' +
                ", namePlane='" + namePlane + '\'' +
                ", status=" + status +
                ", flightHours=" + flightHours +
                ", seatCount=" + seatCount +
                '}';
    }
}

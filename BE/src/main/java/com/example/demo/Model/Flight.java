package com.example.demo.Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Flight")
    private int idFlight;

    @ManyToOne
    @JoinColumn(name = "Id_Plane")
    private Plane plane;

    @Column(name = "Current_Seat")
    private int currentSeat;

    // Dùng Timestamp thay cho chuỗi ngày/giờ
    @Column(name = "Departure_Date")
    private Date departureDate;
    @Column(name = "Departure_Time")
    private Time departureTime;
    @Column(name = "Arrival_Date")
    private Date arrivalDate;
    @Column(name = "Estimated_Arrival_Time")
    private Time estimatedArrivalTime;

    @Column(name = "F_R_O_M")
    private String fromLocation;

    @Column(name = "T_O")
    private String toLocation;

    private Timestamp createdAt;

    public Flight() {
    }

    public Flight(Plane plane, int currentSeat,
            Time departureTime, Time estimatedArrivalTime,
            String fromLocation, String toLocation, Timestamp createdAt) {
        this.plane = plane;
        this.currentSeat = currentSeat;
        this.departureTime = departureTime;
        this.estimatedArrivalTime = estimatedArrivalTime;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.createdAt = createdAt;
    }

    public int getKey() {
        return idFlight;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(plane != null ? String.valueOf(plane.getIdPlane()) : "null");
        value.add(String.valueOf(currentSeat));
        value.add(departureTime != null ? departureTime.toString() : "null");
        value.add(estimatedArrivalTime != null ? estimatedArrivalTime.toString() : "null");
        value.add(fromLocation);
        value.add(toLocation);
        value.add(createdAt != null ? createdAt.toString() : "null");
        return value;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public int getCurrentSeat() {
        return currentSeat;
    }

    public void setCurrentSeat(int currentSeat) {
        this.currentSeat = currentSeat;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(Time estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "idFlight=" + idFlight +
                ", plane=" + plane +
                ", currentSeat=" + currentSeat +
                ", departureTime=" + departureTime +
                ", estimatedArrivalTime=" + estimatedArrivalTime +
                ", fromLocation='" + fromLocation + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

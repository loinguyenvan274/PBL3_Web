package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import com.example.demo.Enum.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Plane")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Plane")
    private int idPlane;
    @Column(name = "Name_Plane")
    private String namePlane;
    @Column(name = "Status")
    private String status;
    @Column(name = "Flight_Hours")
    private int flightHours;
    @Column(name = "Seat_Count")
    private int seatCount;

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    List<Seat> seats = new ArrayList<>();

    public Plane() {
    }

    public Plane(String namePlane, Status status, int flightHours, int seatCount) {
        // this.idPlane = idPlane;
        this.namePlane = namePlane;
        this.status = status.toString();
        this.flightHours = flightHours;
        this.seatCount = seatCount;
    }

    public Plane(int idPlane, String namePlane, Status status, int flightHours, int seatCount) {
        this.idPlane = idPlane;
        this.namePlane = namePlane;
        this.status = status.toString();
        this.flightHours = flightHours;
        this.seatCount = seatCount;
    }

    public List<Seat> getSeat() {
        return seats;
    }

    public void setSeat(List<Seat> seats) {
        this.seats = seats;
    }

    public int getKey() {
        return idPlane;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(namePlane);
        value.add(status.toString());
        value.add(String.valueOf(flightHours));
        value.add(String.valueOf(seatCount));
        return value;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    public String getNamePlane() {
        return namePlane;
    }

    public void setNamePlane(String namePlane) {
        this.namePlane = namePlane;
    }

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public void setStatus(Status status) {
        this.status = status.toString();
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

    public void Copy(Plane plane) {
        this.idPlane = plane.idPlane;
        this.namePlane = plane.namePlane;
        this.status = plane.status;
        this.flightHours = plane.flightHours;
        this.seatCount = plane.seatCount;

    }

    @Override
    public String toString() {
        return "Plane{" +
                "idPlane=" + idPlane +
                ", namePlane='" + namePlane + '\'' +
                ", status=" + status +
                ", flightHours=" + flightHours +
                ", seatCount=" + seatCount +
                '}';
    }
}

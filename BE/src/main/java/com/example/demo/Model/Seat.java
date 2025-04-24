package com.example.demo.Model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;

@Entity
@Table(name = "Seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Seat")
    private int idSeat;
    @Column(name = "Seat_Number")
    private String seatNumber;
    @Column(name = "Seat_Type")
    private String seatType;

    @ManyToOne
    @JoinColumn(name = "Id_Plane")
    private Plane plane;

    public Seat() {
    }

    public Seat(int idSeat, String seatNumber, String seatType, Plane plane) {
        this.idSeat = idSeat;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.plane = plane;
    }

    public int getKey() {
        return idSeat;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(seatNumber);
        value.add(seatType);
        value.add(String.valueOf(plane != null ? plane.getIdPlane() : "null"));
        return value;
    }

    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "idSeat=" + idSeat +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatType='" + seatType + '\'' +
                ", plane=" + (plane != null ? plane.getIdPlane() : "null") +
                '}';
    }
}

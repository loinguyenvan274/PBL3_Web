package com.example.demo.flightsTicketManager;

import java.util.ArrayList;
import java.util.List;

public class Seat {
    private String Id_Seat;
    private String Seat_Number;
    private String Seat_Type;
    private String Id_Plane;

    public Seat() {

    }

    public Seat(String id_Seat, String seat_Number, String seat_Type, String id_Plane) {
        Id_Seat = id_Seat;
        Seat_Number = seat_Number;
        Seat_Type = seat_Type;
        Id_Plane = id_Plane;
    }

    public String getKey() {
        return Id_Seat;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(Seat_Number);
        value.add(Seat_Type);
        value.add(Id_Plane);
        return value;
    }

    public String getId_Seat() {
        return Id_Seat;
    }

    public void setId_Seat(String id_Seat) {
        Id_Seat = id_Seat;
    }

    public String getSeat_Number() {
        return Seat_Number;
    }

    public void setSeat_Number(String seat_Number) {
        Seat_Number = seat_Number;
    }

    public String getSeat_Type() {
        return Seat_Type;
    }

    public void setSeat_Type(String seat_Type) {
        Seat_Type = seat_Type;
    }

    public String getId_Plane() {
        return Id_Plane;
    }

    public void setId_Plane(String id_Plane) {
        Id_Plane = id_Plane;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "Id_Seat='" + Id_Seat + '\'' +
                ", Seat_Number='" + Seat_Number + '\'' +
                ", Seat_Type='" + Seat_Type + '\'' +
                ", Id_Plane='" + Id_Plane + '\'' +
                '}';
    }
}

package com.example.demo.flightsTicketManager;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public class Flights_Seat {
    private String Id_Flights;
    private String Id_Seat;
    private String Seat_Status;

    public Flights_Seat() {
    }

    public Flights_Seat(String id_Flights, String id_Seat, String seat_Status) {
        Id_Flights = id_Flights;
        Id_Seat = id_Seat;
        Seat_Status = seat_Status;
    }

    public String getKey() {
        return Id_Flights;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(Id_Seat);
        value.add(Seat_Status);
        return value;
    }

    @Override
    public String toString() {
        return "Flights_Seat{" +
                "Id_Flights='" + Id_Flights + '\'' +
                ", Id_Seat='" + Id_Seat + '\'' +
                ", Seat_Status='" + Seat_Status + '\'' +
                '}';
    }

    public String getId_Flights() {
        return Id_Flights;
    }

    public void setId_Flights(String id_Flights) {
        Id_Flights = id_Flights;
    }

    public String getId_Seat() {
        return Id_Seat;
    }

    public void setId_Seat(String id_Seat) {
        Id_Seat = id_Seat;
    }

    public String getSeat_Status() {
        return Seat_Status;
    }

    public void setSeat_Status(String seat_Status) {
        Seat_Status = seat_Status;
    }
}

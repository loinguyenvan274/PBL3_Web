package com.example.demo.flightsTicketManager;

import java.util.ArrayList;
import java.util.List;

public class Plane {
    public enum Status {
        MAINTENANCE, NORMAL
    }

    private String Id_Plane;
    private String Id_Area;
    private String Name_Plane;
    private Status Status;
    private int Flight_Hours;
    private int Seat_Count;

    public Plane() {
    }

    public Plane(String Id_Plane, String Id_Area, String Name_Plane, Status Status, int Flight_Hours, int Seat_Count) {
        this.Id_Plane = Id_Plane;
        this.Id_Area = Id_Area;
        this.Name_Plane = Name_Plane;
        this.Status = Status;
        this.Flight_Hours = Flight_Hours;
        this.Seat_Count = Seat_Count;
    }

    public String getKey() {
        return Id_Plane;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(Id_Area);
        value.add(Name_Plane);
        value.add(Status.toString());
        value.add(String.valueOf(Flight_Hours));
        value.add(String.valueOf(Seat_Count));
        return value;
    }

    public String getId_Plane() {
        return Id_Plane;
    }

    public void setId_Plane(String Id_Plane) {
        this.Id_Plane = Id_Plane;
    }

    public String getId_Area() {
        return Id_Area;
    }

    public void setId_Area(String Id_Area) {
        this.Id_Area = Id_Area;
    }

    public String getName_Plane() {
        return Name_Plane;
    }

    public void setName_Plane(String Name_Plane) {
        this.Name_Plane = Name_Plane;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status Status) {
        this.Status = Status;
    }

    public int getFlight_Hours() {
        return Flight_Hours;
    }

    public void setFlight_Hours(int Flight_Hours) {
        this.Flight_Hours = Flight_Hours;
    }

    public int getSeat_Count() {
        return Seat_Count;
    }

    public void setSeat_Count(int Seat_Count) {
        this.Seat_Count = Seat_Count;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "Id_Plane='" + Id_Plane + '\'' +
                ", Id_Area='" + Id_Area + '\'' +
                ", Name_Plane='" + Name_Plane + '\'' +
                ", Status=" + Status +
                ", Flight_Hours=" + Flight_Hours +
                ", Seat_Count=" + Seat_Count +
                '}';
    }
}

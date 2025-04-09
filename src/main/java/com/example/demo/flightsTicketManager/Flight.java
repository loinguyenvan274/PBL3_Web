package com.example.demo.flightsTicketManager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String Id_Flight;
    private String Id_Plane;
    private String Id_Area;
    private int Seat_Count;
    private int Current_Seat;
    private String DEPARTURE_DAY;
    private String DEPARTURE_TIME;
    private String ESTIMATED_ARRIVAL_DAY;
    private String ESTIMATED_ARRIVAL_TIME;
    private String F_R_O_M;
    private String T_O;
    private Timestamp created_at;

    public Flight() {
    }

    public Flight(String Id_Flight, String Id_Plane, String Id_Area, int Seat_Count, int Current_Seat,
            String DEPARTURE_DAY, String DEPARTURE_TIME, String ESTIMATED_ARRIVAL_DAY, String ESTIMATED_ARRIVAL_TIME,
            String F_R_O_M, String T_O, Timestamp created_at) {
        this.Id_Flight = Id_Flight;
        this.Id_Plane = Id_Plane;
        this.Id_Area = Id_Area;
        this.Seat_Count = Seat_Count;
        this.Current_Seat = Current_Seat;
        this.DEPARTURE_DAY = DEPARTURE_DAY;
        this.DEPARTURE_TIME = DEPARTURE_TIME;
        this.ESTIMATED_ARRIVAL_DAY = ESTIMATED_ARRIVAL_DAY;
        this.ESTIMATED_ARRIVAL_TIME = ESTIMATED_ARRIVAL_TIME;
        this.F_R_O_M = F_R_O_M;
        this.T_O = T_O;
        this.created_at = created_at;
    }

    public String getKey() {
        return Id_Flight;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(Id_Plane);
        value.add(Id_Area);
        value.add(String.valueOf(Seat_Count));
        value.add(String.valueOf(Current_Seat));
        value.add(DEPARTURE_DAY);
        value.add(DEPARTURE_TIME);
        value.add(ESTIMATED_ARRIVAL_DAY);
        value.add(ESTIMATED_ARRIVAL_TIME);
        value.add(F_R_O_M);
        value.add(T_O);
        value.add(created_at.toString());
        return value;
    }

    public String getId_Flight() {
        return Id_Flight;
    }

    public void setId_Flight(String Id_Flight) {
        this.Id_Flight = Id_Flight;
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

    public int getSeat_Count() {
        return Seat_Count;
    }

    public void setSeat_Count(int Seat_Count) {
        this.Seat_Count = Seat_Count;
    }

    public int getCurrent_Seat() {
        return Current_Seat;
    }

    public void setCurrent_Seat(int Current_Seat) {
        this.Current_Seat = Current_Seat;
    }

    public String getDEPARTURE_DAY() {
        return DEPARTURE_DAY;
    }

    public void setDEPARTURE_DAY(String DEPARTURE_DAY) {
        this.DEPARTURE_DAY = DEPARTURE_DAY;
    }

    public String getDEPARTURE_TIME() {
        return DEPARTURE_TIME;
    }

    public void setDEPARTURE_TIME(String DEPARTURE_TIME) {
        this.DEPARTURE_TIME = DEPARTURE_TIME;
    }

    public String getESTIMATED_ARRIVAL_DAY() {
        return ESTIMATED_ARRIVAL_DAY;
    }

    public void setESTIMATED_ARRIVAL_DAY(String ESTIMATED_ARRIVAL_DAY) {
        this.ESTIMATED_ARRIVAL_DAY = ESTIMATED_ARRIVAL_DAY;
    }

    public String getESTIMATED_ARRIVAL_TIME() {
        return ESTIMATED_ARRIVAL_TIME;
    }

    public void setESTIMATED_ARRIVAL_TIME(String ESTIMATED_ARRIVAL_TIME) {
        this.ESTIMATED_ARRIVAL_TIME = ESTIMATED_ARRIVAL_TIME;
    }

    public String getF_R_O_M() {
        return F_R_O_M;
    }

    public void setF_R_O_M(String F_R_O_M) {
        this.F_R_O_M = F_R_O_M;
    }

    public String getT_O() {
        return T_O;
    }

    public void setT_O(String T_O) {
        this.T_O = T_O;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "Id_Flight='" + Id_Flight + '\'' +
                ", Id_Plane='" + Id_Plane + '\'' +
                ", Id_Area='" + Id_Area + '\'' +
                ", Seat_Count=" + Seat_Count +
                ", Current_Seat=" + Current_Seat +
                ", DEPARTURE_DAY='" + DEPARTURE_DAY + '\'' +
                ", DEPARTURE_TIME='" + DEPARTURE_TIME + '\'' +
                ", ESTIMATED_ARRIVAL_DAY='" + ESTIMATED_ARRIVAL_DAY + '\'' +
                ", ESTIMATED_ARRIVAL_TIME='" + ESTIMATED_ARRIVAL_TIME + '\'' +
                ", F_R_O_M='" + F_R_O_M + '\'' +
                ", T_O='" + T_O + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}

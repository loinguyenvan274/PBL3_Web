package com.example.demo.flightsTicketManager;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private String Id_Area;
    private int Plane_Count;
    private int Crew_Employee;
    private int ATC_Employee;

    public Area() {
    }

    public Area(String Id_Area, int Plane_Count, int Crew_Employee, int ATC_Employee) {
        this.Id_Area = Id_Area;
        this.Plane_Count = Plane_Count;
        this.Crew_Employee = Crew_Employee;
        this.ATC_Employee = ATC_Employee;
    }

    public String getKey() {
        return Id_Area;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(Integer.toString(Plane_Count));
        value.add(Integer.toString(Crew_Employee));
        value.add(Integer.toString(ATC_Employee));
        return value;
    }

    public String getId_Area() {
        return Id_Area;
    }

    public void setId_Area(String Id_Area) {
        this.Id_Area = Id_Area;
    }

    public int getPlane_Count() {
        return Plane_Count;
    }

    public void setPlane_Count(int Plane_Count) {
        this.Plane_Count = Plane_Count;
    }

    public int getCrew_Employee() {
        return Crew_Employee;
    }

    public void setCrew_Employee(int Crew_Employee) {
        this.Crew_Employee = Crew_Employee;
    }

    public int getATC_Employee() {
        return ATC_Employee;
    }

    public void setATC_Employee(int ATC_Employee) {
        this.ATC_Employee = ATC_Employee;
    }

    @Override
    public String toString() {
        return "Area{" +
                "Id_Area='" + Id_Area + '\'' +
                ", Plane_Count=" + Plane_Count +
                ", Crew_Employee=" + Crew_Employee +
                ", ATC_Employee=" + ATC_Employee +
                '}';
    }
}

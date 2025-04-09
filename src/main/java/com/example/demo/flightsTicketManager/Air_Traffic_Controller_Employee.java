package com.example.demo.flightsTicketManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Air_Traffic_Controller_Employee {
    private String Id_Em;
    private String Full_Name;
    private String Id_Area;
    private Date Day_Of_Birth;

    public Air_Traffic_Controller_Employee() {
    }

    public Air_Traffic_Controller_Employee(String Id_Em, String Full_Name, String Id_Area, Date Day_Of_Birth) {
        this.Id_Em = Id_Em;
        this.Full_Name = Full_Name;
        this.Id_Area = Id_Area;
        this.Day_Of_Birth = Day_Of_Birth;
    }

    public String getKey() {
        return Id_Em;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(Full_Name);
        value.add(Id_Area);
        value.add(Day_Of_Birth.toString());
        return value;
    }

    // Getter và Setter
    public String getId_Em() {
        return Id_Em;
    }

    public void setId_Em(String Id_Em) {
        this.Id_Em = Id_Em;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String Full_Name) {
        this.Full_Name = Full_Name;
    }

    public String getId_Area() {
        return Id_Area;
    }

    public void setId_Area(String Id_Area) {
        this.Id_Area = Id_Area;
    }

    public Date getDay_Of_Birth() {
        return Day_Of_Birth;
    }

    public void setDay_Of_Birth(Date Day_Of_Birth) {
        this.Day_Of_Birth = Day_Of_Birth;
    }

    @Override
    public String toString() {
        return "AirTrafficControllerEmployee{" +
                "Id_Em='" + Id_Em + '\'' +
                ", Full_Name='" + Full_Name + '\'' +
                ", Id_Area='" + Id_Area + '\'' +
                ", Day_Of_Birth=" + Day_Of_Birth +
                '}';
    }
}

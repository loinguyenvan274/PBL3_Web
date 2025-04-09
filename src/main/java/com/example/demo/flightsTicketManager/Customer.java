package com.example.demo.flightsTicketManager;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer {
    private String Id_Card;
    private String Full_Name;
    private String Tel;
    private String Email;
    private String Country;
    private Date Day_Of_Birth;
    private Time created_at;

    public Customer() {
    }

    public Customer(String Id_Card, String Full_Name) {
        this.Id_Card = Id_Card;
        this.Full_Name = Full_Name;
    }

    public String getKey() {
        return Id_Card;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(Full_Name);
        value.add(Tel);
        value.add(Email);
        value.add(Country);
        value.add(Day_Of_Birth.toString());
        value.add(created_at.toString());
        return value;
    }

    public String getId_Card() {
        return Id_Card;
    }

    public void setId_Card(String Id_Card) {
        this.Id_Card = Id_Card;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String Full_Name) {
        this.Full_Name = Full_Name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public Date getDay_Of_Birth() {
        return Day_Of_Birth;
    }

    public void setDay_Of_Birth(Date Day_Of_Birth) {
        this.Day_Of_Birth = Day_Of_Birth;
    }

    public Time getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Time created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id_Card='" + Id_Card + '\'' +
                ", Full_Name='" + Full_Name + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Email='" + Email + '\'' +
                ", Country='" + Country + '\'' +
                ", Day_Of_Birth=" + Day_Of_Birth +
                ", created_at=" + created_at +
                '}';
    }
}

package com.example.demo.flightsTicketManager;

import java.util.Date;

public class AirTrafficControllerEmployee {
    private String idEm;
    private String fullName;
    private String idArea;
    private Date dayOfBirth;

    public AirTrafficControllerEmployee() {
    }

    public AirTrafficControllerEmployee(String idEm, String fullName, String idArea, Date dayOfBirth) {
        this.idEm = idEm;
        this.fullName = fullName;
        this.idArea = idArea;
        this.dayOfBirth = dayOfBirth;
    }

    // Getter và Setter
    public String getIdEm() {
        return idEm;
    }

    public void setIdEm(String idEm) {
        this.idEm = idEm;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return "AirTrafficControllerEmployee{" +
                "idEm='" + idEm + '\'' +
                ", fullName='" + fullName + '\'' +
                ", idArea='" + idArea + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                '}';
    }
}

package com.example.demo.flightsTicketManager;

import java.util.Date;

public class Crew {
    private String idCrewEm;
    private String fullName;
    private String idArea;
    private String position;
    private Date dayOfBirth;

    public Crew() {
    }

    public Crew(String idCrewEm, String fullName, String idArea, String position, Date dayOfBirth) {
        this.idCrewEm = idCrewEm;
        this.fullName = fullName;
        this.idArea = idArea;
        this.position = position;
        this.dayOfBirth = dayOfBirth;
    }

    public String getIdCrewEm() {
        return idCrewEm;
    }

    public void setIdCrewEm(String idCrewEm) {
        this.idCrewEm = idCrewEm;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "idCrewEm='" + idCrewEm + '\'' +
                ", fullName='" + fullName + '\'' +
                ", idArea='" + idArea + '\'' +
                ", position='" + position + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                '}';
    }
}

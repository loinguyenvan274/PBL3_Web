package com.example.demo.flightsTicketManager;

public class Area {
    private String idArea;
    private int planeCount;
    private int crewEmployee;
    private int atcEmployee;

    public Area() {
    }

    public Area(String idArea, int planeCount, int crewEmployee, int atcEmployee) {
        this.idArea = idArea;
        this.planeCount = planeCount;
        this.crewEmployee = crewEmployee;
        this.atcEmployee = atcEmployee;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public int getPlaneCount() {
        return planeCount;
    }

    public void setPlaneCount(int planeCount) {
        this.planeCount = planeCount;
    }

    public int getCrewEmployee() {
        return crewEmployee;
    }

    public void setCrewEmployee(int crewEmployee) {
        this.crewEmployee = crewEmployee;
    }

    public int getAtcEmployee() {
        return atcEmployee;
    }

    public void setAtcEmployee(int atcEmployee) {
        this.atcEmployee = atcEmployee;
    }

    @Override
    public String toString() {
        return "Area{" +
                "idArea='" + idArea + '\'' +
                ", planeCount=" + planeCount +
                ", crewEmployee=" + crewEmployee +
                ", atcEmployee=" + atcEmployee +
                '}';
    }
}

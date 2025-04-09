package com.example.demo.flightsTicketManager;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Employee_Schedule {
    private String Id_Flight;
    private String Id_Crew_Em;
    private Time Shift_Time;
    private Date Duty_date;

    public Employee_Schedule() {
    }

    public Employee_Schedule(String id_Flight, String id_Crew_Em, Time shift_Time, Date duty_date) {
        Id_Flight = id_Flight;
        Id_Crew_Em = id_Crew_Em;
        Shift_Time = shift_Time;
        Duty_date = duty_date;
    }

    public String getKey() {
        return Id_Flight;
    }

    public List<String> valueString() {
        List<String> value = new ArrayList<>();
        value.add(Id_Crew_Em);
        value.add(Shift_Time.toString());
        value.add(Duty_date.toString());
        return value;
    }

    @Override
    public String toString() {
        return "Employee_Schedule{" +
                "Id_Flight='" + Id_Flight + '\'' +
                ", Id_Crew_Em='" + Id_Crew_Em + '\'' +
                ", Shift_Time=" + Shift_Time +
                ", Duty_date=" + Duty_date +
                '}';
    }

    public String getId_Flight() {
        return Id_Flight;
    }

    public void setId_Flight(String id_Flight) {
        Id_Flight = id_Flight;
    }

    public String getId_Crew_Em() {
        return Id_Crew_Em;
    }

    public void setId_Crew_Em(String id_Crew_Em) {
        Id_Crew_Em = id_Crew_Em;
    }

    public Time getShift_Time() {
        return Shift_Time;
    }

    public void setShift_Time(Time shift_Time) {
        Shift_Time = shift_Time;
    }

    public Date getDuty_date() {
        return Duty_date;
    }

    public void setDuty_date(Date duty_date) {
        Duty_date = duty_date;
    }
}

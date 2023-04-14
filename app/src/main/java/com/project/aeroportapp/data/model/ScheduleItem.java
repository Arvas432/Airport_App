package com.project.aeroportapp.data.model;

public class ScheduleItem {
    private Flight closest;
    private String date;
    private String airline;
    public ScheduleItem(Flight flight_, String date_, String Airline)
    {
        closest = flight_;
        date = date_;
        airline = Airline;
    }

    public Flight getClosest() {
        return closest;
    }

    public String getAirline() {
        return airline;
    }

    public String getDate() {
        return date;
    }
}

package com.project.aeroportapp.data.model;

public class ScheduleItem {
    private Flight closest;
    private String date;
    private String airline;
    private String flightnumber;
    public ScheduleItem(Flight flight_, String date_)
    {
        closest = flight_;
        date = date_;
    }

    public Flight getClosest() {
        return closest;
    }

    public String getFlightnumber() {
        return closest.getFlightCode();
    }

    public String getAirline() {
        return closest.getAirline();
    }


    public String getDate() {
        return date;
    }
    public String getTime(){
        return closest.getTime();
    }
}

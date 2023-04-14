package com.project.aeroportapp.data.model;

public class Flight {
    private String city;
    private String time;
    private String flightCode;
    private Boolean registrationFinished;
    private String airline;
    private String gate;

    public Flight(String City,String Time, String FlightCode, Boolean RegistrationFinished, String Airline, String Gate)
    {
        time = Time;
        flightCode = FlightCode;
        registrationFinished = RegistrationFinished;
        airline = Airline;
        gate = Gate;
        city = City;
    }
    public String getFlightCode()
    {
        return flightCode;
    }
    public String getCity(){return city;}
    public Boolean getRegistrationFinished(){return registrationFinished;}
    public String getAirline(){return airline;}
    public String getGate(){return gate;}

    public String getTime() {
        return time;
    }
}

package com.project.aeroportapp.data;

import com.project.aeroportapp.data.entities.FlightEntity;
import com.project.aeroportapp.data.model.Flight;

public class Mapper {
    public static Flight FlightEntityToFlight(FlightEntity f)
    {
        Flight answer = new Flight(f.getCity(), f.getTime(), f.getFlightCode(), f.getRegistrationFinished(), f.getAirline(), f.getGate());
        return answer;
    }

}

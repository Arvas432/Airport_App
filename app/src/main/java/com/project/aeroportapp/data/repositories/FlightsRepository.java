package com.project.aeroportapp.data.repositories;
import com.project.aeroportapp.data.data_sources.FlightsSource;
import com.project.aeroportapp.data.model.Flight;

import java.util.ArrayList;

public class FlightsRepository
{
    public static ArrayList<Flight> get(){
        return new ArrayList<>(FlightsSource.flights);
    }
    public static Flight add(Flight input)
    {
        FlightsSource.add(input);
        return input;
    }
}

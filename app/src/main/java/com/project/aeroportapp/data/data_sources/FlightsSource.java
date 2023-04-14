package com.project.aeroportapp.data.data_sources;

import com.project.aeroportapp.data.model.Flight;

import java.util.ArrayList;

public class FlightsSource {
    public static ArrayList<Flight> flights = new ArrayList<Flight>(){
        {
            add(new Flight("Владивосток", "21:30","АF412", false,"Аэрофлот","B4"));
            add(new Flight("Токио", "22:10","UT412",false,"UTAIR","G1"));
            add(new Flight("Лондон", "22:45","RA315",true,"RyanAir","A5"));
            add(new Flight("Анталия", "23:20","TA513",false,"Turkish Airlines","B1"));
            add(new Flight("Рязань", "0:10","AF122",false,"Аэрофлот","D2"));
            add(new Flight("Екатеринбург", "0:45","UR512",false,"Ural Airlines","F5"));
            add(new Flight("Алматы", "1:15","AA433",false,"Air Astana","G1"));
        }

    };
    public static ArrayList<Flight> get()
    {
        return new ArrayList<>(flights);
    }
    public static Flight add(Flight input)
    {
        flights.add(input);
        return input;
    }

}

package com.project.aeroportapp.data.data_sources;

import com.project.aeroportapp.data.model.Destination;

import java.util.ArrayList;

public class DestinationSource {
    public static ArrayList<Destination> destinations = new ArrayList<Destination>() {
        {
            add(new Destination("Владивосток", false));
            add(new Destination("Токио", true));
            add(new Destination("Лондон", true));
            add(new Destination("Анталия", true));
            add(new Destination("Рязань", false));
            add(new Destination("Екатеринбург", false));
            add(new Destination("Алматы", true));
        }
    };
    public static ArrayList<Destination> get()
    {
        return new ArrayList<Destination>(destinations);
    }
    public static Destination add(Destination input)
    {
        destinations.add(input);
        return input;
    }
}

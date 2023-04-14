package com.project.aeroportapp.data.repositories;

import com.project.aeroportapp.data.data_sources.DestinationSource;
import com.project.aeroportapp.data.model.Destination;

import java.util.ArrayList;

public class DestinationsRepository {
    public static ArrayList<Destination> get(){
        return new ArrayList<>(DestinationsRepository.get());
    }
    public static Destination add(Destination input)
    {
        DestinationSource.add(input);
        return input;
    }
}

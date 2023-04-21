package com.project.aeroportapp.data.repositories;
import com.project.aeroportapp.data.data_sources.AppDatabase;
import com.project.aeroportapp.data.data_sources.FlightDAO;
import com.project.aeroportapp.data.data_sources.FlightsSource;
import com.project.aeroportapp.data.entities.FlightEntity;
import com.project.aeroportapp.data.model.Flight;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class FlightsRepository
{
    FlightsSource fs;
    private FlightDAO flightDAO;

    private MutableLiveData<List<FlightEntity>> flights = new MutableLiveData<>(new ArrayList<>());
    public FlightsRepository()
    {

        fs = new FlightsSource();
    }

    public MutableLiveData<List<Flight>> get(){

        MutableLiveData<List<Flight>> result = new MutableLiveData<>();
        result.setValue(fs.get());
        return result;
    }
    public Flight add(Flight input)
    {
        return fs.add(input);
    }
}

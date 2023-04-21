package com.project.aeroportapp.ui.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.project.aeroportapp.data.data_sources.AppDatabase;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.repositories.FlightsRepository;

import java.util.List;

public class FlightTableViewModel extends ViewModel {
    FlightsRepository fr;
    public MutableLiveData<List<Flight>> flightdata;
    public FlightTableViewModel()
    {
        fr = new FlightsRepository();
        flightdata = fr.get();
    }
    public LiveData<List<Flight>> getflightdata() {
        return flightdata;
    }
    public List<Flight> getFlights(){
        if (flightdata.getValue() == null){
            flightdata.setValue(fr.get().getValue());
        }
        return flightdata.getValue();
    }
}

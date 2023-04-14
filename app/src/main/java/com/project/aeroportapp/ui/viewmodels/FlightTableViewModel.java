package com.project.aeroportapp.ui.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.repositories.FlightsRepository;

import java.util.List;

public class FlightTableViewModel extends ViewModel {
    private final MutableLiveData<List<Flight>> flightdata
            = new MutableLiveData<List<Flight>>(null);
    public LiveData<List<Flight>> getflightdata() {
        return flightdata;
    }
    public List<Flight> getFlights(){
        if (flightdata.getValue() == null){
            flightdata.setValue(FlightsRepository.get());
        }
        return flightdata.getValue();
    }
}

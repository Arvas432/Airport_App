package com.project.aeroportapp.ui.viewmodels;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.repositories.FlightsDatabaseRepos;
import com.project.aeroportapp.data.repositories.FlightsRepository;

import java.util.List;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.project.aeroportapp.data.data_sources.AppDatabase;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.entities.FlightEntity;
import com.project.aeroportapp.data.repositories.FlightsRepository;
public class DatabaseViewModel extends ViewModel{
    FlightsDatabaseRepos fr;
    public LiveData<List<Flight>> flightdata;
    public DatabaseViewModel(Application app)
    {

        fr = new FlightsDatabaseRepos(app);
        flightdata = fr.get();

    }
    public LiveData<List<Flight>> getflightdata() {
        return flightdata;
    }
    public List<Flight> getFlights(){
        if (flightdata.getValue() == null){
            flightdata = fr.get();
        }
        return flightdata.getValue();
    }
}

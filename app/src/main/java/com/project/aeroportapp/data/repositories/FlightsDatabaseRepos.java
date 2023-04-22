package com.project.aeroportapp.data.repositories;
import android.app.Application;
import android.content.Context;

import com.project.aeroportapp.data.data_sources.AppDatabase;
import com.project.aeroportapp.data.data_sources.FlightDAO;
import com.project.aeroportapp.data.data_sources.FlightsSource;
import com.project.aeroportapp.data.entities.FlightEntity;
import com.project.aeroportapp.data.model.Flight;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class FlightsDatabaseRepos
{
    private FlightDAO flightDAO;

    private MutableLiveData<List<FlightEntity>> flights = new MutableLiveData<>(new ArrayList<>());
    public FlightsDatabaseRepos(Fragment frag)
    {
        AppDatabase db = AppDatabase.getDatabase(frag.requireActivity().getApplication());
        flightDAO = db.flightDAO();
    }

    public MutableLiveData<List<FlightEntity>> get(){

        MutableLiveData<List<FlightEntity>> result = new MutableLiveData<>();
        AppDatabase.databaseWriteExecutor.execute(()->{
            result.postValue(flightDAO.getFlightsList());
        });
        return result;
    }
}

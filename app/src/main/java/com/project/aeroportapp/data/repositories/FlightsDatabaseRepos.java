package com.project.aeroportapp.data.repositories;
import android.app.Application;

import com.project.aeroportapp.data.data_sources.AppDatabase;
import com.project.aeroportapp.data.dao.FlightDAO;
import com.project.aeroportapp.data.entities.FlightEntity;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.Mapper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class FlightsDatabaseRepos
{
    private FlightDAO flightDAO;
    public FlightsDatabaseRepos(Application app)
    {
        AppDatabase db = AppDatabase.getDatabase(app);
        flightDAO = db.flightDAO();

    }

    public LiveData<List<Flight>> get(){
        MutableLiveData<List<Flight>> result = new MutableLiveData<>();
        List<Flight> cache = new ArrayList<>();
        AppDatabase.databaseWriteExecutor.execute(()->{
            for(FlightEntity f: flightDAO.getFlightsList())
            {
                cache.add(Mapper.FlightEntityToFlight(f));
            }
            result.postValue(cache);
        });
        return result;
    }
}

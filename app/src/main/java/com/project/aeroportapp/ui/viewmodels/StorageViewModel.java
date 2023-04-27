package com.project.aeroportapp.ui.viewmodels;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.project.aeroportapp.R;
import com.project.aeroportapp.data.entities.FlightEntity;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.repositories.FlightsDatabaseRepos;
import com.project.aeroportapp.data.repositories.FlightsRepository;
import com.project.aeroportapp.data.repositories.StorageDataRepository;

import java.util.List;

public class StorageViewModel extends ViewModel {
    private StorageDataRepository repository;
    private FlightsDatabaseRepos repos;
    private Application app;
    public StorageViewModel(Application application)
    {
        app = application;
        repository = new StorageDataRepository(application);
        repos = new FlightsDatabaseRepos(application);
    }
    public void writeToFile()
    {
        repository.saveLastFlight();
    }



}

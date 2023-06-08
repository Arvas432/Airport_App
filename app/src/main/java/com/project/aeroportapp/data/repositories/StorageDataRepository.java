package com.project.aeroportapp.data.repositories;
import android.app.Application;

import androidx.fragment.app.Fragment;

import com.project.aeroportapp.data.dao.FlightDAO;
import com.project.aeroportapp.data.data_sources.AppDatabase;
import com.project.aeroportapp.data.data_sources.StorageDataSource;

import java.util.Date;

public class StorageDataRepository {
    private StorageDataSource ds;
    public void add(String input)
    {
        ds.writeTo(input);
    }
    public void SharedPref()
    {
        ds.WriteToSharedPref();
    }

    public void saveLastFlight(String input)
    {
        add(input);
    }
    public StorageDataRepository(Application app)
    {
        ds = new StorageDataSource(app);
    }

}

package com.project.aeroportapp.data.repositories;
import android.app.Application;

import androidx.fragment.app.Fragment;

import com.project.aeroportapp.data.dao.FlightDAO;
import com.project.aeroportapp.data.data_sources.AppDatabase;
import com.project.aeroportapp.data.data_sources.StorageDataSource;

import java.util.Date;

public class StorageDataRepository {
    private FlightDAO flightDAO;
    private StorageDataSource ds;
    public void add(String input)
    {
        ds.writeTo(input);
    }
    public void saveLastFlight()
    {
        String input = new Date() + " " + flightDAO.getFlightsList().get(0).getFlightCode() + " " + flightDAO.getFlightsList().get(0).getAirline() + " " + flightDAO.getFlightsList().get(0).getCity() + "\n";
        add(input);
    }
    public StorageDataRepository(Application app)
    {
        ds = new StorageDataSource(app);
        AppDatabase db = AppDatabase.getDatabase(app);
        flightDAO = db.flightDAO();
    }

}

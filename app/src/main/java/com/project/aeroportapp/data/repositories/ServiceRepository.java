package com.project.aeroportapp.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.project.aeroportapp.data.dao.FlightDAO;
import com.project.aeroportapp.data.data_sources.FlightsSource;
import com.project.aeroportapp.data.data_sources.ServiceDataSource;
import com.project.aeroportapp.data.entities.FlightEntity;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.model.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    ServiceDataSource ss;
    private FlightDAO flightDAO;

    private MutableLiveData<List<Service>> flights = new MutableLiveData<>(new ArrayList<>());
    public ServiceRepository()
    {

        ss = new ServiceDataSource();
    }

    public MutableLiveData<List<Service>> get(){

        MutableLiveData<List<Service>> result = new MutableLiveData<>();
        result.setValue(ss.get());
        return result;
    }
    public Service add(Service input)
    {
        return ss.add(input);
    }
}

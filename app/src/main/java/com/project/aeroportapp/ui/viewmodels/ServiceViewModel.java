package com.project.aeroportapp.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.model.Service;
import com.project.aeroportapp.data.repositories.FlightsRepository;
import com.project.aeroportapp.data.repositories.ServiceRepository;

import java.util.List;

public class ServiceViewModel extends ViewModel {
    ServiceRepository sr;
    public MutableLiveData<List<Service>> servicedata;
    public ServiceViewModel()
    {
        sr = new ServiceRepository();
        servicedata = sr.get();
    }
    public LiveData<List<Service>> getServiceData() {
        return servicedata;
    }
    public List<Service> getServices(){
        if (servicedata.getValue() == null){
            servicedata.setValue(sr.get().getValue());
        }
        return servicedata.getValue();
    }
}

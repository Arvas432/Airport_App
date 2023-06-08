package com.project.aeroportapp.data.data_sources;

import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.model.Service;

import java.util.ArrayList;

public class ServiceDataSource {
    ArrayList<Service> services = new ArrayList<Service>(){
        {
            add(new Service("VIP зона"));
            add(new Service("Багаж"));
            add(new Service("Финансы"));
            add(new Service("Помощь"));
            add(new Service("Ожидание"));
            add(new Service("Подключение WIFI"));
            add(new Service("Залы сна и отдыха"));
            add(new Service("Транспорт"));
            add(new Service("Гостиницы"));
        }

    };
    public ArrayList<Service> get()
    {
        return new ArrayList<>(services);
    }
    public Service add(Service input)
    {
        services.add(input);
        return input;
    }
}

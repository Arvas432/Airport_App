package com.project.aeroportapp.data.repositories;

import com.project.aeroportapp.data.data_sources.FlightsSource;
import com.project.aeroportapp.data.data_sources.ScheduleSource;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.model.ScheduleItem;

import java.util.ArrayList;

public class ScheduleItemRepository {
    public static ArrayList<ScheduleItem> get(){
        return new ArrayList<>(ScheduleSource.ScheduleItems);
    }
    public static ScheduleItem add(ScheduleItem input)
    {
        ScheduleSource.add(input);
        return input;
    }
}

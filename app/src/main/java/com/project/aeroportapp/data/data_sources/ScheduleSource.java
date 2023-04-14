package com.project.aeroportapp.data.data_sources;

import com.project.aeroportapp.data.model.Destination;
import com.project.aeroportapp.data.model.ScheduleItem;

import java.util.ArrayList;

public class ScheduleSource {
    public static ArrayList<ScheduleItem> ScheduleItems = new ArrayList<ScheduleItem>() {
        {

        }
    };
    public static ArrayList<ScheduleItem> get()
    {
        return new ArrayList<ScheduleItem>(ScheduleItems);
    }
    public static ScheduleItem add(ScheduleItem input)
    {
        ScheduleItems.add(input);
        return input;
    }
}

package com.project.aeroportapp.data.data_sources;

import com.project.aeroportapp.data.model.Destination;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.model.ScheduleItem;

import java.util.ArrayList;

public class ScheduleSource {
    public static ArrayList<ScheduleItem> ScheduleItems = new ArrayList<ScheduleItem>() {
        {
            add(new ScheduleItem(new Flight("Владивосток", "21:30","АF412", false,"Аэрофлот","B4"),"19.07.2023"));
            add(new ScheduleItem(new Flight("Токио", "22:10","UT412",false,"UTAIR","G1"),"20.07.2023"));
            add(new ScheduleItem(new Flight("Лондон", "22:45","RA315",true,"RyanAir","A5"),"21.07.2023"));
            add(new ScheduleItem(new Flight("Анталия", "23:20","TA513",false,"Turkish Airlines","B1"),"22.07.2023"));
            add(new ScheduleItem(new Flight("Рязань", "0:10","AF122",false,"Аэрофлот","D2"),"23.07.2023"));
            add(new ScheduleItem(new Flight("Екатеринбург", "0:45","UR512",false,"Ural Airlines","F5"),"24.07.2023"));
            add(new ScheduleItem(new Flight("Алматы", "1:15","AA433",false,"Air Astana","G1"),"25.07.2023"));

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

package com.project.aeroportapp.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.model.ScheduleItem;
import com.project.aeroportapp.data.repositories.FlightsRepository;
import com.project.aeroportapp.data.repositories.ScheduleItemRepository;

import java.util.List;

public class ScheduleViewModel extends ViewModel {
    private final MutableLiveData<List<ScheduleItem>> scheduledata
            = new MutableLiveData<List<ScheduleItem>>(null);
    public LiveData<List<ScheduleItem>> getscheduledata() {
        return scheduledata;
    }
    public List<ScheduleItem> getScheduleItems(){
        if (scheduledata.getValue() == null){
            scheduledata.setValue(ScheduleItemRepository.get());
        }
        return scheduledata.getValue();
    }
}

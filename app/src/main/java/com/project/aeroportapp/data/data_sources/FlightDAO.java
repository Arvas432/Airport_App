package com.project.aeroportapp.data.data_sources;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.lifecycle.MutableLiveData;

import com.project.aeroportapp.data.entities.FlightEntity;
import com.project.aeroportapp.data.model.Flight;

import java.util.List;

@Dao
public abstract class FlightDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insertPart(FlightEntity flight);

    @Transaction
    public FlightEntity insert(FlightEntity flight) {
        long id = insertPart(flight);
        return getById(id);
    }
    @Query("DELETE FROM flightsTable")
    public abstract void deleteAll();
    @Query("SELECT * FROM flightsTable")
    public abstract List<FlightEntity> getFlightsList();
    @Query("SELECT * FROM flightsTable WHERE partId = :id LIMIT 1")
    public abstract FlightEntity getById(long id);


}

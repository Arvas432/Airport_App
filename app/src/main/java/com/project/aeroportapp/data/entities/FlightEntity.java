package com.project.aeroportapp.data.entities;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "flightsTable")
public class FlightEntity {
    @PrimaryKey(autoGenerate = true)
    private long PartId;
    private String city;
    private String time;
    private String flightCode;
    private Boolean registrationFinished;
    private String airline;
    private String gate;
    public FlightEntity(
            String City, String Time, String FlightCode, Boolean RegistrationFinished, String Airline, String Gate
    ){
        this.city = City;
        this.time = Time;
        this.flightCode = FlightCode;
        this.registrationFinished = RegistrationFinished;
        this.airline = Airline;
        this.gate = Gate;
    }
    public FlightEntity()
    {
        this.city = "City";
        this.time = "Time";
        this.flightCode = "FlightCode";
        this.registrationFinished = false;
        this.airline = "Airline";
        this.gate = "Gate";
    }

    public String getTime() {
        return time;
    }
    public String getAirline() {
        return airline;
    }

    public Boolean getRegistrationFinished() {
        return registrationFinished;
    }

    public long getPartId() {
        return PartId;
    }

    public String getCity() {
        return city;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public String getGate() {
        return gate;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public void setPartId(int flightId) {
        PartId = flightId;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public void setRegistrationFinished(Boolean registrationFinished) {
        this.registrationFinished = registrationFinished;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

package com.example.tripbuddy.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trips")
public class Trip {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String destination;
    private String date;
    private String budget;

    public Trip(String destination, String date, String budget) {
        this.destination = destination;
        this.date = date;
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }
}
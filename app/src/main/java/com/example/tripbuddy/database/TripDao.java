package com.example.tripbuddy.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tripbuddy.models.Trip;

import java.util.List;

@Dao
public interface TripDao {

    @Insert
    void insertTrip(Trip trip);

    @Delete
    void deleteTrip(Trip trip);

    @Query("SELECT * FROM trips")
    List<Trip> getAllTrips();
}
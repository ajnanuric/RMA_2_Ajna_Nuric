package com.example.tripbuddy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tripbuddy.R;
import com.example.tripbuddy.adapters.TripAdapter;
import com.example.tripbuddy.database.TripDatabase;
import com.example.tripbuddy.models.Trip;

import java.util.List;

public class TripsFragment extends Fragment {

    EditText editDestination, editDate, editBudget;

    EditText editFlightBudget, editHotelBudget,
            editFoodBudget, editActivitiesBudget;

    Button buttonAddTrip, buttonCalculate;

    TextView textBudgetResult;

    RecyclerView recyclerTrips;

    TripDatabase database;

    List<Trip> tripList;

    TripAdapter adapter;

    public TripsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trips, container, false);

        editDestination = view.findViewById(R.id.editDestination);
        editDate = view.findViewById(R.id.editDate);
        editBudget = view.findViewById(R.id.editBudget);

        editFlightBudget = view.findViewById(R.id.editFlightBudget);
        editHotelBudget = view.findViewById(R.id.editHotelBudget);
        editFoodBudget = view.findViewById(R.id.editFoodBudget);
        editActivitiesBudget = view.findViewById(R.id.editActivitiesBudget);

        buttonAddTrip = view.findViewById(R.id.buttonAddTrip);
        buttonCalculate = view.findViewById(R.id.buttonCalculate);

        textBudgetResult = view.findViewById(R.id.textBudgetResult);

        recyclerTrips = view.findViewById(R.id.recyclerTrips);

        database = TripDatabase.getInstance(requireContext());

        recyclerTrips.setLayoutManager(new LinearLayoutManager(getContext()));

        loadTrips();

        buttonAddTrip.setOnClickListener(v -> {

            String destination = editDestination.getText().toString().trim();
            String date = editDate.getText().toString().trim();
            String budget = editBudget.getText().toString().trim();

            if(destination.isEmpty() || date.isEmpty() || budget.isEmpty()) {

                Toast.makeText(getContext(),
                        "Unesite sve podatke",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            Trip trip = new Trip(destination, date, budget);

            database.tripDao().insertTrip(trip);

            Toast.makeText(getContext(),
                    "Trip dodan",
                    Toast.LENGTH_SHORT).show();

            editDestination.setText("");
            editDate.setText("");
            editBudget.setText("");

            loadTrips();

        });

        buttonCalculate.setOnClickListener(v -> {

            String flights = editFlightBudget.getText().toString();
            String hotel = editHotelBudget.getText().toString();
            String food = editFoodBudget.getText().toString();
            String activities = editActivitiesBudget.getText().toString();

            if(flights.isEmpty() || hotel.isEmpty()
                    || food.isEmpty() || activities.isEmpty()) {

                Toast.makeText(getContext(),
                        "Unesite sve budžete",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            int flightsBudget = Integer.parseInt(flights);
            int hotelBudget = Integer.parseInt(hotel);
            int foodBudget = Integer.parseInt(food);
            int activitiesBudget = Integer.parseInt(activities);

            int total = flightsBudget + hotelBudget
                    + foodBudget + activitiesBudget;

            String result =
                    "Flights: " + flightsBudget + "€\n\n" +
                            "Hotel: " + hotelBudget + "€\n\n" +
                            "Food: " + foodBudget + "€\n\n" +
                            "Activities: " + activitiesBudget + "€\n\n" +
                            "Total Budget: " + total + "€";

            textBudgetResult.setText(result);

        });

        return view;
    }

    private void loadTrips() {

        tripList = database.tripDao().getAllTrips();

        adapter = new TripAdapter(tripList);

        recyclerTrips.setAdapter(adapter);
    }
}
package com.example.tripbuddy.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tripbuddy.R;

public class BudgetActivity extends AppCompatActivity {

    EditText editFlights,
            editHotels,
            editFood,
            editActivities;

    Button buttonCalculateBudget;

    TextView textBudget,
            textFlightsResult,
            textHotelsResult,
            textFoodResult,
            textActivitiesResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        editFlights = findViewById(R.id.editFlights);
        editHotels = findViewById(R.id.editHotels);
        editFood = findViewById(R.id.editFood);
        editActivities = findViewById(R.id.editActivities);

        buttonCalculateBudget =
                findViewById(R.id.buttonCalculateBudget);

        textBudget = findViewById(R.id.textBudget);

        textFlightsResult =
                findViewById(R.id.textFlightsResult);

        textHotelsResult =
                findViewById(R.id.textHotelsResult);

        textFoodResult =
                findViewById(R.id.textFoodResult);

        textActivitiesResult =
                findViewById(R.id.textActivitiesResult);

        buttonCalculateBudget.setOnClickListener(v -> {

            String flights =
                    editFlights.getText().toString();

            String hotels =
                    editHotels.getText().toString();

            String food =
                    editFood.getText().toString();

            String activities =
                    editActivities.getText().toString();

            if(flights.isEmpty()
                    || hotels.isEmpty()
                    || food.isEmpty()
                    || activities.isEmpty()) {

                Toast.makeText(this,
                        "Unesite sve podatke",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            int total =
                    Integer.parseInt(flights)
                            + Integer.parseInt(hotels)
                            + Integer.parseInt(food)
                            + Integer.parseInt(activities);

            textBudget.setText(total + "€");

            textFlightsResult.setText(
                    "✈ Flights: " + flights + "€");

            textHotelsResult.setText(
                    "🏨 Hotels: " + hotels + "€");

            textFoodResult.setText(
                    "🍔 Food: " + food + "€");

            textActivitiesResult.setText(
                    "🎯 Activities: " + activities + "€");

        });
    }
}
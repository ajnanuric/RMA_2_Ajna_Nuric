package com.example.tripbuddy.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tripbuddy.R;

public class FlightsActivity extends AppCompatActivity {

    EditText editAirline, editDeparture,
            editArrival, editPrice;

    Button buttonAddFlight;

    TextView textFlights;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);

        editAirline = findViewById(R.id.editAirline);
        editDeparture = findViewById(R.id.editDeparture);
        editArrival = findViewById(R.id.editArrival);
        editPrice = findViewById(R.id.editPrice);

        buttonAddFlight = findViewById(R.id.buttonAddFlight);

        textFlights = findViewById(R.id.textFlights);

        buttonAddFlight.setOnClickListener(v -> {

            String airline = editAirline.getText().toString();
            String departure = editDeparture.getText().toString();
            String arrival = editArrival.getText().toString();
            String price = editPrice.getText().toString();

            if(airline.isEmpty() || departure.isEmpty()
                    || arrival.isEmpty() || price.isEmpty()) {

                Toast.makeText(this,
                        "Unesite sve podatke",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            String flight =
                    "Airline: " + airline + "\n" +
                            "Departure: " + departure + "\n" +
                            "Arrival: " + arrival + "\n" +
                            "Price: " + price + "€\n\n";

            textFlights.append(flight);

            editAirline.setText("");
            editDeparture.setText("");
            editArrival.setText("");
            editPrice.setText("");

        });
    }
}
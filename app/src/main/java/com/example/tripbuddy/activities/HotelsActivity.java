package com.example.tripbuddy.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tripbuddy.R;

public class HotelsActivity extends AppCompatActivity {

    EditText editHotelName, editNights, editHotelPrice;

    Button buttonAddHotel;

    TextView textHotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        editHotelName = findViewById(R.id.editHotelName);
        editNights = findViewById(R.id.editNights);
        editHotelPrice = findViewById(R.id.editHotelPrice);

        buttonAddHotel = findViewById(R.id.buttonAddHotel);

        textHotels = findViewById(R.id.textHotels);

        buttonAddHotel.setOnClickListener(v -> {

            String hotel = editHotelName.getText().toString();
            String nights = editNights.getText().toString();
            String price = editHotelPrice.getText().toString();

            if(hotel.isEmpty() || nights.isEmpty() || price.isEmpty()) {

                Toast.makeText(this,
                        "Unesite sve podatke",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            String result =
                    "Hotel: " + hotel + "\n" +
                            "Nights: " + nights + "\n" +
                            "Price: " + price + "€\n\n";

            textHotels.append(result);

            editHotelName.setText("");
            editNights.setText("");
            editHotelPrice.setText("");

        });
    }
}
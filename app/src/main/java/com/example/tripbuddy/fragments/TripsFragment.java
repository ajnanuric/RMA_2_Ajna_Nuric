package com.example.tripbuddy.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tripbuddy.R;
import com.example.tripbuddy.activities.BudgetActivity;
import com.example.tripbuddy.activities.PackingActivity;
import com.example.tripbuddy.activities.FlightsActivity;
import com.example.tripbuddy.activities.HotelsActivity;
import com.example.tripbuddy.activities.NotesActivity;
import com.example.tripbuddy.activities.DocumentsActivity;

public class TripsFragment extends Fragment {

    CardView cardBudget;
    CardView cardPacking;
    CardView cardFlights;
    CardView cardHotels;
    CardView cardNotes;
    CardView cardDocuments;

    public TripsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trips, container, false);

        cardBudget = view.findViewById(R.id.cardBudget);
        cardPacking = view.findViewById(R.id.cardPacking);
        cardFlights = view.findViewById(R.id.cardFlights);
        cardHotels = view.findViewById(R.id.cardHotels);
        cardNotes = view.findViewById(R.id.cardNotes);
        cardDocuments = view.findViewById(R.id.cardDocuments);

        cardBudget.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), BudgetActivity.class);
            startActivity(intent);

        });
        cardPacking.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), PackingActivity.class);
            startActivity(intent);

        });
        cardFlights.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), FlightsActivity.class);
            startActivity(intent);

        });

        cardHotels.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), HotelsActivity.class);
            startActivity(intent);

        });

        cardNotes.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), NotesActivity.class);
            startActivity(intent);

        });

        cardDocuments.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), DocumentsActivity.class);
            startActivity(intent);

        });

        return view;
    }
}
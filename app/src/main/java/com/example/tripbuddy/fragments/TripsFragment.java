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

public class TripsFragment extends Fragment {

    CardView cardBudget;

    public TripsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_trips, container, false);

        cardBudget = view.findViewById(R.id.cardBudget);

        cardBudget.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), BudgetActivity.class);
            startActivity(intent);

        });

        return view;
    }
}
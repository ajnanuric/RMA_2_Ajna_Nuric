package com.example.tripbuddy.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tripbuddy.R;
import com.example.tripbuddy.activities.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.widget.Button;
public class ProfileFragment extends Fragment {

    TextView textUserEmail;

  Button buttonDarkMode;

    FirebaseAuth auth;

    FirebaseUser user;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        textUserEmail = view.findViewById(R.id.textUserEmail);

        buttonDarkMode = view.findViewById(R.id.buttonDarkMode);

        View logoutCard = view.findViewById(R.id.logoutCard);
        View editProfileCard = view.findViewById(R.id.editProfileCard);
        View aboutCard = view.findViewById(R.id.aboutCard);
        View passwordCard = view.findViewById(R.id.passwordCard);

        auth = FirebaseAuth.getInstance();

        user = auth.getCurrentUser();

        if(user != null) {

            textUserEmail.setText(user.getEmail());
        }

        logoutCard.setOnClickListener(v -> {

            auth.signOut();

            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);

            requireActivity().finish();

        });

        editProfileCard.setOnClickListener(v -> {

            Toast.makeText(getContext(),
                    "Edit Profile feature clicked ✨",
                    Toast.LENGTH_SHORT).show();

        });

        aboutCard.setOnClickListener(v -> {

            Toast.makeText(getContext(),
                    "TripBuddy helps users organize trips, budgets and travel plans ✈️",
                    Toast.LENGTH_LONG).show();

        });

        passwordCard.setOnClickListener(v -> {

            Toast.makeText(getContext(),
                    "Password change feature coming soon 🔒",
                    Toast.LENGTH_SHORT).show();

        });

        final boolean[] darkMode = {false};

        buttonDarkMode.setOnClickListener(v -> {

            if(!darkMode[0]) {

                view.setBackgroundColor(0xFF2C2C2C);

                Toast.makeText(getContext(),
                        "Dark mode enabled 🌙",
                        Toast.LENGTH_SHORT).show();

                darkMode[0] = true;

            } else {

                view.setBackgroundResource(R.drawable.profile_background);

                Toast.makeText(getContext(),
                        "Light mode enabled ☀️",
                        Toast.LENGTH_SHORT).show();

                darkMode[0] = false;
            }

        });

        return view;
    }
}
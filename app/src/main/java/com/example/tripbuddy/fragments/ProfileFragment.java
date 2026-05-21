package com.example.tripbuddy.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tripbuddy.R;
import com.example.tripbuddy.activities.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    TextView textUserEmail;

    Button buttonLogout;

    FirebaseAuth auth;

    FirebaseUser user;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        textUserEmail = view.findViewById(R.id.textUserEmail);

        buttonLogout = view.findViewById(R.id.buttonLogout);

        auth = FirebaseAuth.getInstance();

        user = auth.getCurrentUser();

        if(user != null) {

            textUserEmail.setText(user.getEmail());
        }

        buttonLogout.setOnClickListener(v -> {

            auth.signOut();

            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);

            requireActivity().finish();

        });

        return view;
    }
}
package com.example.tripbuddy.viewmodel;

import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;

public class AuthViewModel extends ViewModel {

    private FirebaseAuth auth;

    public AuthViewModel() {
        auth = FirebaseAuth.getInstance();
    }

    public void login(String email, String password) {
        auth.signInWithEmailAndPassword(email, password);
    }

    public void register(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password);
    }

    public void logout() {
        auth.signOut();
    }
}
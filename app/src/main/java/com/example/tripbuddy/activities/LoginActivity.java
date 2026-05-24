package com.example.tripbuddy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tripbuddy.R;
import com.example.tripbuddy.viewmodel.AuthViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    Button buttonLogin;
    TextView textRegister;

    EditText editEmail, editPassword;

    AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonLogin = findViewById(R.id.buttonLogin);
        textRegister = findViewById(R.id.textRegister);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

        authViewModel = new ViewModelProvider(this)
                .get(AuthViewModel.class);

        buttonLogin.setOnClickListener(v -> {

            String email = editEmail.getText().toString().trim();
            String password = editPassword.getText().toString().trim();

            if(email.isEmpty() || password.isEmpty()) {

                Toast.makeText(this, "Unesite podatke", Toast.LENGTH_SHORT).show();
                return;
            }

            authViewModel.login(email, password);

            FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {

                        if(task.isSuccessful()) {

                            Toast.makeText(this,
                                    "Login uspješan",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(
                                    LoginActivity.this,
                                    MainActivity.class);

                            startActivity(intent);
                            finish();

                        } else {

                            Toast.makeText(this,
                                    "Pogrešan email ili password",
                                    Toast.LENGTH_LONG).show();
                        }

                    });

        });

        textRegister.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    RegisterActivity.class);

            startActivity(intent);

        });
    }
}
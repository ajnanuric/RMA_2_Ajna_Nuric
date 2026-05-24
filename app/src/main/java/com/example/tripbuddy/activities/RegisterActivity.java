package com.example.tripbuddy.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tripbuddy.R;
import com.example.tripbuddy.viewmodel.AuthViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText editName, editRegisterEmail, editRegisterPassword;
    Button buttonRegister;

    AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editName = findViewById(R.id.editName);
        editRegisterEmail = findViewById(R.id.editRegisterEmail);
        editRegisterPassword = findViewById(R.id.editRegisterPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        authViewModel = new ViewModelProvider(this)
                .get(AuthViewModel.class);

        buttonRegister.setOnClickListener(v -> {

            String email = editRegisterEmail.getText().toString().trim();
            String password = editRegisterPassword.getText().toString().trim();

            if(email.isEmpty() || password.isEmpty()) {

                Toast.makeText(this,
                        "Unesite podatke",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            authViewModel.register(email, password);

            FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {

                        if(task.isSuccessful()) {

                            Toast.makeText(this,
                                    "Registracija uspješna",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(
                                    RegisterActivity.this,
                                    MainActivity.class);

                            startActivity(intent);
                            finish();

                        } else {

                            Toast.makeText(this,
                                    "Greška: " +
                                            task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                    });

        });

    }
}
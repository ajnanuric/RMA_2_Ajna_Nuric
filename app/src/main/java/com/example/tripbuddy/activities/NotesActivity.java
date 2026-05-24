package com.example.tripbuddy.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tripbuddy.R;

public class NotesActivity extends AppCompatActivity {

    EditText editNotes;

    Button buttonSaveNotes;

    TextView textSavedNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        editNotes = findViewById(R.id.editNotes);

        buttonSaveNotes = findViewById(R.id.buttonSaveNotes);

        textSavedNotes = findViewById(R.id.textSavedNotes);

        buttonSaveNotes.setOnClickListener(v -> {

            String notes = editNotes.getText().toString().trim();

            if(notes.isEmpty()) {

                Toast.makeText(this,
                        "Unesite notes",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            textSavedNotes.setText(notes);

            Toast.makeText(this,
                    "Notes saved",
                    Toast.LENGTH_SHORT).show();

        });
    }
}
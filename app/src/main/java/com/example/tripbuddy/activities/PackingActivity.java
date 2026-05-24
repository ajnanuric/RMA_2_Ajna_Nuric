package com.example.tripbuddy.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripbuddy.R;
import com.example.tripbuddy.adapters.PackingAdapter;
import com.example.tripbuddy.models.PackingItem;

import java.util.ArrayList;
import java.util.List;

public class PackingActivity extends AppCompatActivity {

    EditText editPacking;

    Button buttonAddItem;

    RecyclerView recyclerPacking;

    List<PackingItem> packingList;

    PackingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packing);

        editPacking = findViewById(R.id.editPacking);

        buttonAddItem = findViewById(R.id.buttonAddItem);

        recyclerPacking = findViewById(R.id.recyclerPacking);

        recyclerPacking.setLayoutManager(
                new LinearLayoutManager(this));

        packingList = new ArrayList<>();

        adapter = new PackingAdapter(packingList);

        recyclerPacking.setAdapter(adapter);

        buttonAddItem.setOnClickListener(v -> {

            String item = editPacking.getText().toString().trim();

            if(item.isEmpty()) {

                Toast.makeText(this,
                        "Unesite item",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            packingList.add(new PackingItem(item));

            adapter.notifyDataSetChanged();

            editPacking.setText("");

        });
    }
}
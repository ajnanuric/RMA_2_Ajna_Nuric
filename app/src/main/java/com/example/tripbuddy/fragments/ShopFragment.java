package com.example.tripbuddy.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.tripbuddy.R;
import com.example.tripbuddy.adapters.ProductAdapter;
import com.example.tripbuddy.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    RecyclerView recyclerProducts;

    EditText editSearch;

    List<Product> productList;

    List<Product> filteredList;

    ProductAdapter adapter;

    public ShopFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        recyclerProducts = view.findViewById(R.id.recyclerProducts);

        editSearch = view.findViewById(R.id.editSearch);

        recyclerProducts.setLayoutManager(new LinearLayoutManager(getContext()));

        productList = new ArrayList<>();

        productList.add(new Product(
                "E-SIM",
                "Stay connected while traveling",
                "19€",
                R.drawable.esim));

        productList.add(new Product(
                "Gift Card",
                "Perfect gift for travelers",
                "50€",
                R.drawable.giftcard));

        productList.add(new Product(
                "Suitcase",
                "Travel in style",
                "120€",
                R.drawable.suitcase));

        productList.add(new Product(
                "Travel Pillow",
                "Comfort on long flights",
                "25€",
                R.drawable.pillow));

        productList.add(new Product(
                "Backpack",
                "Carry your essentials",
                "80€",
                R.drawable.backpack));

        productList.add(new Product(
                "Power Bank",
                "Charge anywhere",
                "40€",
                R.drawable.powerbank));


        filteredList = new ArrayList<>(productList);

        adapter = new ProductAdapter(filteredList);

        recyclerProducts.setAdapter(adapter);

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                filterProducts(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    private void filterProducts(String text) {

        filteredList.clear();

        for(Product product : productList) {

            if(product.getTitle().toLowerCase().contains(text.toLowerCase())) {

                filteredList.add(product);
            }
        }

        adapter.notifyDataSetChanged();
    }
}
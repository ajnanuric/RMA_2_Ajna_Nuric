package com.example.tripbuddy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripbuddy.R;
import com.example.tripbuddy.models.City;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    List<City> cityList;

    public CityAdapter(List<City> cityList) {
        this.cityList = cityList;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city, parent, false);

        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {

        City city = cityList.get(position);

        holder.textCityName.setText(city.getName());
        holder.textCityDescription.setText(city.getDescription());
        holder.textCityBudget.setText(city.getBudget());

        holder.imageCity.setImageResource(city.getImage());
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public static class CityViewHolder extends RecyclerView.ViewHolder {

        ImageView imageCity;

        TextView textCityName,
                textCityDescription,
                textCityBudget;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);

            imageCity = itemView.findViewById(R.id.imageCity);

            textCityName = itemView.findViewById(R.id.textCityName);
            textCityDescription = itemView.findViewById(R.id.textCityDescription);
            textCityBudget = itemView.findViewById(R.id.textCityBudget);
        }
    }
}
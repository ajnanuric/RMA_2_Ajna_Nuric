package com.example.tripbuddy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripbuddy.R;
import com.example.tripbuddy.models.PackingItem;

import java.util.List;

public class PackingAdapter extends RecyclerView.Adapter<PackingAdapter.PackingViewHolder> {

    List<PackingItem> packingList;

    public PackingAdapter(List<PackingItem> packingList) {
        this.packingList = packingList;
    }

    @NonNull
    @Override
    public PackingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_packing, parent, false);

        return new PackingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PackingViewHolder holder, int position) {

        PackingItem item = packingList.get(position);

        holder.checkPackingItem.setText(item.getItemName());
    }

    @Override
    public int getItemCount() {
        return packingList.size();
    }

    public static class PackingViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkPackingItem;

        public PackingViewHolder(@NonNull View itemView) {
            super(itemView);

            checkPackingItem = itemView.findViewById(R.id.checkPackingItem);
        }
    }
}
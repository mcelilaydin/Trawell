package com.mca.trawell;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mca.trawell.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationHolder> {

    ArrayList<Location> locationArrayList;

    public LocationAdapter(ArrayList<Location> locationArrayList){
        this.locationArrayList = locationArrayList;
    }

    @NonNull
    @Override
    public LocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LocationHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.binding.recyclerViewTextView.setText(locationArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),LocationActivity.class);
                intent.putExtra("info","old");
                intent.putExtra("id",locationArrayList.get(position).id);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return locationArrayList.size();
    }

    public class LocationHolder extends RecyclerView.ViewHolder{
        private RecyclerRowBinding binding;

        public LocationHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}

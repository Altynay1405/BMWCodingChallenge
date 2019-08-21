package com.example.bmwcodingchallenge;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmwcodingchallenge.data.LocationPojo;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder> {
    Context mContext;
    List<LocationPojo> locationPojos;
    public LocationAdapter(Context context, List<LocationPojo> locationList) {
        mContext = context;
        locationPojos = locationList;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View location_row = inflater.inflate(R.layout.list_item_location,parent,false);
        return new LocationViewHolder(location_row);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.nameTextView.setText(locationPojos.get(position).getName());
        holder.addressTextView.setText(locationPojos.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return locationPojos.size();
    }
}

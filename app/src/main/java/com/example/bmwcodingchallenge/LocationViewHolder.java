package com.example.bmwcodingchallenge;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

class LocationViewHolder extends RecyclerView.ViewHolder {
    TextView nameTextView;
    TextView addressTextView;

    public LocationViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.textView_name);
        addressTextView =  itemView.findViewById(R.id.textView_address);
    }
}

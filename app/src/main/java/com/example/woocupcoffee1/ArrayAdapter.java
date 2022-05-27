package com.example.woocupcoffee1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.ViewHolder> {
    private ArrayList<User> dataModalArrayList;
    private Context context;

    // constructor class for our Adapter
    public ArrayAdapter(ArrayList<User> dataModalArrayList, Context context) {
        this.dataModalArrayList = dataModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ArrayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ArrayAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArrayAdapter.ViewHolder holder, int position) {
        // setting data to our views in Recycler view items.
        final User modal = dataModalArrayList.get(position);
        holder.courseNameTV.setText(modal.getName());

        // we are using Picasso to load images
        // from
    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return dataModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our
        // views of recycler items.
        private TextView courseNameTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing the views of recycler views.
            courseNameTV = itemView.findViewById(R.id.textView13);
        }
    }
}
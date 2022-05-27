package com.example.woocupcoffee1;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends CursorAdapter {
    public MyArrayAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView name1 = (TextView) view.findViewById(R.id.textView);
        TextView price1 = (TextView) view.findViewById(R.id.textView11);
        ImageView image = (ImageView) view.findViewById(R.id.imageView17);
        // Extract properties from cursor
        String name = cursor.getString(cursor.getColumnIndexOrThrow("Kinds_of_menu"));
        String price = cursor.getString(cursor.getColumnIndexOrThrow("Price"));
        int photo = cursor.getInt(cursor.getColumnIndexOrThrow("Photo"));
        // Populate fields with extracted properties
        name1.setText(name);
        price1.setText(price);
        image.setImageResource(photo);
    }
}

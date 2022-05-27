package com.example.woocupcoffee1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Admin_zakaz extends AppCompatActivity {
    TextView admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_zakaz);
        admin=findViewById(R.id.textView38);
        admin.setText(getIntent().getStringExtra("name"));
    }
}
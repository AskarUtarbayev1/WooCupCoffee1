package com.example.woocupcoffee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import maes.tech.intentanim.CustomIntent;

public class Inform_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform_page);
    }
    public void start1(View view){
        Intent intent=new Intent(Inform_page.this,Inform_page2.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void back1(View view){
        Intent intent=new Intent(Inform_page.this,Menu.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
}
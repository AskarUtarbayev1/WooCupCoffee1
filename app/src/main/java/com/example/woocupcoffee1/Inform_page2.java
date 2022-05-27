package com.example.woocupcoffee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import maes.tech.intentanim.CustomIntent;
public class Inform_page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform_page2);
    }
    public void start2(View view){
        Intent intent=new Intent(Inform_page2.this,Inform_page3.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void back2(View view){
        Intent intent=new Intent(Inform_page2.this,Menu.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
}
package com.example.woocupcoffee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void start(View view){
        Intent intent=new Intent(MainActivity.this,Inform_page.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
}
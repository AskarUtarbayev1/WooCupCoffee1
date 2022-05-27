package com.example.woocupcoffee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import maes.tech.intentanim.CustomIntent;

public class Booking extends AppCompatActivity {
    TimePicker time;
    DatePicker date;
    TextView text;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    String minandsec;
    String date1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        sqLiteDatabaseObj = openOrCreateDatabase("Cafe", Context.MODE_PRIVATE, null);
        time = findViewById(R.id.timepicker);
        text=findViewById(R.id.textView6);
        date = findViewById(R.id.datePicker);
        time.setIs24HourView(true);
        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                minandsec=i+":"+i1;
            }
        });
        date.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                date1=i+"-"+i1+"-"+i2;
            }
        });
    }
    public void backk(View view){
        Intent intent=new Intent(Booking.this,Menu.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void plus(View view){
        int sum=Integer.valueOf(text.getText().toString());
        sum=sum+1;
        text.setText(String.valueOf(sum));
    }
    public void minus(View view){
        int sum=Integer.valueOf(text.getText().toString());
        if(sum>=1){
            sum=sum-1;
            text.setText(String.valueOf(sum));
        }

    }
    public void bron(View view){
        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS Book(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name VARCHAR, Call_number VARCHAR,Count_people Varchar,Date_d varchar,Time_t Varchar);");
        SQLiteDataBaseQueryHolder = "INSERT INTO Book (Name,Call_number,Count_people,Date_d,Time_t) VALUES('"+"Askar"+"', '"+"888888"+"', '"+text.getText().toString()+"', '"+date1+"', '"+minandsec+"');";
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.bron_toast, (ViewGroup) findViewById(R.id.toast_layout_root));
        ImageView image = (ImageView) layout.findViewById(R.id.image);
        image.setImageResource(R.drawable.qqqqqq);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
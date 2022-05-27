package com.example.woocupcoffee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import maes.tech.intentanim.CustomIntent;

public class Register extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    EditText name,email,number,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sqLiteDatabaseObj = openOrCreateDatabase("Cafe", Context.MODE_PRIVATE, null);
        name = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextPersonName3);
        number = findViewById(R.id.editTextTextPersonName4);
        password = findViewById(R.id.editTextTextPersonName5);
    }
    public void register(View view){
        String user=email.getText().toString();
        String pass=password.getText().toString();
        String name1=name.getText().toString();
        String number1=number.getText().toString();
        if(user.equals("")|| pass.equals("") || name1.equals("")|| number1.equals(""))
            Toast.makeText(Register.this, "Пожалуйста заполните окошки", Toast.LENGTH_SHORT).show();
        else if(pass.length()<8){
            Toast.makeText(Register.this, "Пароль должен иметь больше 8-ми знаков,букв или чисел", Toast.LENGTH_SHORT).show();
        }
        else if(!number1.matches("-?\\d+(\\.\\d+)?")){
            Toast.makeText(Register.this, "Контактные данные должны быть из чисел", Toast.LENGTH_SHORT).show();
        }
        else{
        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS User(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name VARCHAR, Email VARCHAR,Call_number Varchar,Password Varchar);");
        SQLiteDataBaseQueryHolder = "INSERT INTO User (Name,Email,Call_number,Password) VALUES('"+name.getText().toString()+"', '"+email.getText().toString()+"', '"+number.getText().toString()+"', '"+password.getText().toString()+"');";
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
        Intent intent=new Intent(Register.this,Voity.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");}
    }
    public void backk(View view){
        Intent intent=new Intent(Register.this,Menu.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void voity(View view){
        Intent intent=new Intent(Register.this,Voity.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
}
package com.example.woocupcoffee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import maes.tech.intentanim.CustomIntent;

public class Voity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder;
    EditText email,password;
    TextView voity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voity);
        sqLiteDatabaseObj = openOrCreateDatabase("Cafe", Context.MODE_PRIVATE, null);
        email = findViewById(R.id.editTextTextPersonName8);
        password = findViewById(R.id.editTextTextPersonName6);
    }
    public Boolean checkusernamepassword(String username, String password){
        Cursor cursor = sqLiteDatabaseObj.rawQuery("Select rowid _id,* from User where Email = ? and Password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public void voity(View view){
        String user = email.getText().toString();
        String pass = password.getText().toString();
        if(user.equals("")||pass.equals(""))
            Toast.makeText(Voity.this, "Пожалуйста заполните окошки", Toast.LENGTH_SHORT).show();
        else{
            Boolean checkuserpass = checkusernamepassword(user, pass);
            if(checkuserpass==true){
                String name = "",call_number="";
                Toast.makeText(Voity.this, "Вы вошли в систему", Toast.LENGTH_SHORT).show();
                Cursor cursor = sqLiteDatabaseObj.rawQuery("Select rowid _id,* from User where Email = ? and Password = ?", new String[] {user,pass});
                if (cursor.moveToFirst()){
                    do {
                        // Passing values
                        name = cursor.getString(2);
                        call_number = cursor.getString(4);
                    } while(cursor.moveToNext());
                    cursor.close();}
                Intent intent=new Intent(Voity.this,Menu.class);
                intent.putExtra("name",name);
                intent.putExtra("call_number",call_number);
                startActivity(intent);
                CustomIntent.customType(this,"fadein-to-fadeout");
            }else{
                Toast.makeText(Voity.this, "Неправильный пароль или эл.почта", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void backk(View view){
        Intent intent=new Intent(Voity.this,Register.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void register(View view){
        Intent intent=new Intent(Voity.this,Register.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }

}
package com.example.woocupcoffee1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import maes.tech.intentanim.CustomIntent;
import java.time.*;
import java.util.List;
import java.util.Locale;

public class Menu extends AppCompatActivity {
    TextView text,kinds;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder,SQLiteDataBaseQueryHolder1,SQLiteDataBaseQueryHolder2,SQLiteDataBaseQueryHolder3,
            SQLiteDataBaseQueryHolder4,SQLiteDataBaseQueryHolder5,SQLiteDataBaseQueryHolder6,SQLiteDataBaseQueryHolder7,SQLiteDataBaseQueryHolder8,
            SQLiteDataBaseQueryHolder9,SQLiteDataBaseQueryHolder10,SQLiteDataBaseQueryHolder11,SQLiteDataBaseQueryHolder12,SQLiteDataBaseQueryHolder13,
            SQLiteDataBaseQueryHolder14,SQLiteDataBaseQueryHolder15,SQLiteDataBaseQueryHolder16,SQLiteDataBaseQueryHolder17;
    GridView gridView;
    RadioButton kofe,chai,limonade,smuzi;
    ImageButton search;
    EditText searchtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        sqLiteDatabaseObj = openOrCreateDatabase("Cafe", Context.MODE_PRIVATE, null);
        text=findViewById(R.id.textView4);
        kinds=findViewById(R.id.textView11);
        gridView=findViewById(R.id.gridview);
        kofe= findViewById(R.id.kofe);
        chai=findViewById(R.id.chai);
        limonade=findViewById(R.id.limonade);
        smuzi= findViewById(R.id.smuzi);
        searchtext=findViewById(R.id.editTextTextPersonName);
        search=findViewById(R.id.imageButton);
        Date currentDate = new Date();
        DateFormat timeFormat = new SimpleDateFormat("HH", Locale.getDefault());
        String timeText = timeFormat.format(currentDate);
        if(Integer.parseInt(timeText)<12 && Integer.parseInt(timeText)>7){
            text.setText("на Завтрак?");
        }else if(Integer.parseInt(timeText)<18 && Integer.parseInt(timeText)>=12){
            text.setText("на Обед?");
        }else{
            text.setText("на Ужин?");
        }
        final Cursor curs = sqLiteDatabaseObj.rawQuery("SELECT rowid _id,* FROM Menu WHERE List_of_menu = ?", new String[] {"Кофе"});
        MyArrayAdapter todoAdapter = new MyArrayAdapter(this, curs);
        gridView.setAdapter(todoAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Cursor cursor = (Cursor) adapterView.getAdapter().getItem(i);
                Intent intent=new Intent(Menu.this,Zakaz1.class);
                intent.putExtra("name",getIntent().getStringExtra("name"));
                intent.putExtra("call_number",getIntent().getStringExtra("call_number"));
                String s=cursor.getString(3);
                intent.putExtra("weight",s);
                startActivity(intent);
            }
        });



//        if (c.moveToFirst()){
//            do {
//                // Passing values
//                String lis = c.getString(0);
//                String men = c.getString(1);
//                String pric = c.getString(2);
//                Integer phot = c.getInt(3);
//                list.setText((CharSequence)lis);
//                kinds.setText((CharSequence)men);
//                price.setText((CharSequence)pric);
//                image.setImageResource(phot);
//                // Do something Here with values
//            } while(c.moveToNext());}
}
    public void Search(View view){
        String search=searchtext.getText().toString();
        Cursor curs = sqLiteDatabaseObj.rawQuery("SELECT rowid _id,* FROM Menu WHERE Kinds_of_menu = ?", new String[] {search});
        MyArrayAdapter todoAdapter = new MyArrayAdapter(this, curs);
        gridView.setAdapter(todoAdapter);
    }
    public void Logo(View view){
        Intent intent=new Intent(Menu.this,MainActivity.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void Second(View view){
        Intent intent=new Intent(Menu.this,Izbran.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void Third(View view){
        Intent intent=new Intent(Menu.this,Zakaz2.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void fourth(View view){
        Intent intent=new Intent(Menu.this,Register.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void Booking(View view){
        Intent intent=new Intent(Menu.this,Booking.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str="";
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.kofe:
                if(checked){
                    Cursor curs = sqLiteDatabaseObj.rawQuery("SELECT rowid _id,* FROM Menu WHERE List_of_menu = ?", new String[] {"Кофе"});
                MyArrayAdapter todoAdapter = new MyArrayAdapter(this, curs);
                gridView.setAdapter(todoAdapter);}
                break;
            case R.id.chai:
                if(checked){
                    Cursor curs = sqLiteDatabaseObj.rawQuery("SELECT rowid _id,* FROM Menu WHERE List_of_menu = ?", new String[] {"Чай"});
                    MyArrayAdapter todoAdapter = new MyArrayAdapter(this, curs);
                    gridView.setAdapter(todoAdapter);}
                break;
            case R.id.limonade:
                if(checked){
                    Cursor curs = sqLiteDatabaseObj.rawQuery("SELECT rowid _id,* FROM Menu WHERE List_of_menu = ?", new String[] {"Лимонады"});
                    MyArrayAdapter todoAdapter = new MyArrayAdapter(this, curs);
                    gridView.setAdapter(todoAdapter);}
                break;
            case R.id.smuzi:
                if(checked){
                    Cursor curs = sqLiteDatabaseObj.rawQuery("SELECT rowid _id,* FROM Menu WHERE List_of_menu = ?", new String[] {"Смузи"});
                    MyArrayAdapter todoAdapter = new MyArrayAdapter(this, curs);
                    gridView.setAdapter(todoAdapter);}
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
    public void InsertDataIntoSQLiteDatabase(){
            sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS Menu(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, List_of_menu VARCHAR, Kinds_of_menu VARCHAR,Price Varchar,Photo INTEGER);");
            SQLiteDataBaseQueryHolder = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Кофе"+"', '"+"Эспрессо"+"', '"+"450тг"+"', '"+R.drawable.espresso+"');";
            SQLiteDataBaseQueryHolder1 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Кофе"+"', '"+"Американо"+"', '"+"700тг"+"', '"+R.drawable.american+"');";
            SQLiteDataBaseQueryHolder2 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Кофе"+"', '"+"Капучино"+"', '"+"650тг"+"', '"+R.drawable.capuchino+"');";
            SQLiteDataBaseQueryHolder3 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Кофе"+"', '"+"Флэт Уайт"+"', '"+"850тг"+"', '"+R.drawable.latte+"');";
        SQLiteDataBaseQueryHolder4 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Кофе"+"', '"+"Латте"+"', '"+"850тг"+"', '"+R.drawable.latte+"');";
        SQLiteDataBaseQueryHolder5 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Кофе"+"', '"+"Раф"+"', '"+"1000тг"+"', '"+R.drawable.raf+"');";
        SQLiteDataBaseQueryHolder6 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Кофе"+"', '"+"Шоколад"+"', '"+"850тг"+"', '"+R.drawable.shocolad+"');";
        SQLiteDataBaseQueryHolder7 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Лимонады"+"', '"+"Ягодный"+"', '"+"1150тг"+"', '"+R.drawable.pngwing_com_4+"');";
        SQLiteDataBaseQueryHolder8 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Лимонады"+"', '"+"Имбирный"+"', '"+"1150тг"+"', '"+R.drawable.limonade_transparentes_fond_png+"');";
        SQLiteDataBaseQueryHolder9 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Лимонады"+"', '"+"Облепиховый"+"', '"+"1150тг"+"', '"+R.drawable.pngwing_com_5+"');";
        SQLiteDataBaseQueryHolder10 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Смузи"+"', '"+"Ягодный"+"', '"+"1450тг"+"', '"+R.drawable.pngwing_com_6+"');";
        SQLiteDataBaseQueryHolder11 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Смузи"+"', '"+"Клубника"+"', '"+"1450тг"+"', '"+R.drawable.pngwing_com_7+"');";
        SQLiteDataBaseQueryHolder12 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Смузи"+"', '"+"Смородина"+"', '"+"1450тг"+"', '"+R.drawable.yagodniye+"');";
        SQLiteDataBaseQueryHolder13 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Чай"+"', '"+"Черный"+"', '"+"900тг"+"', '"+R.drawable.cherniy+"');";
        SQLiteDataBaseQueryHolder14 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Чай"+"', '"+"Эрл Грей"+"', '"+"900тг"+"', '"+R.drawable.cherniy+"');";
        SQLiteDataBaseQueryHolder15 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Чай"+"', '"+"Зеленый"+"', '"+"900тг"+"', '"+R.drawable.zeleniy+"');";
        SQLiteDataBaseQueryHolder16 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Чай"+"', '"+"Имбирный"+"', '"+"1450тг"+"', '"+R.drawable.oblepihf+"');";
        SQLiteDataBaseQueryHolder17 = "INSERT INTO Menu (List_of_menu,Kinds_of_menu,Price,Photo) VALUES('"+"Чай"+"', '"+"Ягодный"+"', '"+"1450тг"+"', '"+R.drawable.tea_png98912+"');";
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder1);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder2);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder3);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder4);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder5);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder6);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder7);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder8);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder9);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder10);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder11);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder12);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder13);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder14);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder15);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder16);
        sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder17);
    }
    public void deletetable(){
        sqLiteDatabaseObj.delete("Menu", null, null);
    }


}
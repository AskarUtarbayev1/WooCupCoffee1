package com.example.woocupcoffee1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import maes.tech.intentanim.CustomIntent;

public class Zakaz1 extends AppCompatActivity {
    TextView text,text1,item,price;
    ImageView photo;
    SQLiteDatabase sqLiteDatabaseObj1;
    String SQLiteDataBaseQueryHolder;
    RecyclerView courseRV;
    Integer phot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakaz1);
        sqLiteDatabaseObj1 = openOrCreateDatabase("Cafe", Context.MODE_PRIVATE, null);
        courseRV = findViewById(R.id.list_item);
        text=findViewById(R.id.textView6);
        text1=findViewById(R.id.textView14);
        ArrayList<User> storeContacts = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setHasFixedSize(true);


        // creating our new array lis
        item=findViewById(R.id.textView12);
        price=findViewById(R.id.textView9);
        photo=findViewById(R.id.imageView12);
        String tweigth=getIntent().getStringExtra("weight");
        Cursor c = sqLiteDatabaseObj1.rawQuery("SELECT rowid _id,* FROM Menu_list WHERE Kinds_of_menu = ?", new String[] {tweigth});
        if (c.moveToFirst()){
            do {
                // Passing values
                String men = c.getString(2);
                String phno = c.getString(3);
                storeContacts.add(new User(phno));
                Integer pric = c.getInt(5);
                phot = c.getInt(6);
                item.setText(men);
                price.setText(String.valueOf(pric));
                photo.setImageResource(phot);
                // Do something Here with values
            } while(c.moveToNext());
            c.close();
            ArrayList<User> allContacts = storeContacts;
            courseRV.setVisibility(View.VISIBLE);
            ArrayAdapter mAdapter = new ArrayAdapter(allContacts,this);
            courseRV.setAdapter(mAdapter);
        }
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
    public void zakaz(View view){
        Intent intent=new Intent(Zakaz1.this,Zakaz2.class);
        String item1=item.getText().toString();
        String price1=price.getText().toString();
        intent.putExtra("name",getIntent().getStringExtra("name"));
        intent.putExtra("call_number",getIntent().getStringExtra("call_number"));
        intent.putExtra("item",item1);
        intent.putExtra("price",price1);
        intent.putExtra("photo",phot.toString());
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void backk(View view){
        Intent intent=new Intent(Zakaz1.this,Menu.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void heart(View view){
        Intent intent=new Intent(Zakaz1.this,Izbran.class);
        String item1=item.getText().toString();
        String price1=price.getText().toString();
        intent.putExtra("item",item1);
        intent.putExtra("price",price1);
        intent.putExtra("photo",phot.toString());
        intent.putExtra("name",getIntent().getStringExtra("name"));
        intent.putExtra("call_number",getIntent().getStringExtra("call_number"));
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }

    public void InsertDataIntoSQLiteDatabase(){
        sqLiteDatabaseObj1.execSQL("CREATE TABLE IF NOT EXISTS Menu_list(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Kinds_of_menu VARCHAR,Ingredients varchar,Heart boolean,Price INTEGER,Photo INTEGER);");
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Эспрессо"+"', '"+"Вода"+"', '"+false+"', '"+450+"', '"+R.drawable.espresso+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Эспрессо"+"', '"+"Молоко"+"', '"+false+"', '"+450+"', '"+R.drawable.espresso+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Эспрессо"+"', '"+"Сахар"+"', '"+false+"', '"+450+"', '"+R.drawable.espresso+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Эспрессо"+"', '"+"Сироп"+"', '"+false+"', '"+450+"', '"+R.drawable.espresso+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Латте"+"', '"+"Вода"+"', '"+false+"', '"+850+"', '"+R.drawable.latte+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Латте"+"', '"+"Кофе"+"', '"+false+"', '"+850+"', '"+R.drawable.latte+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Латте"+"', '"+"Сахар"+"', '"+false+"', '"+850+"', '"+R.drawable.latte+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Латте"+"', '"+"Молоко"+"', '"+false+"', '"+850+"', '"+R.drawable.latte+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Американо"+"', '"+"Вода"+"', '"+false+"', '"+750+"', '"+R.drawable.american+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Американо"+"', '"+"Сахар"+"', '"+false+"', '"+750+"', '"+R.drawable.american+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Американо"+"', '"+"Кофе"+"', '"+false+"', '"+750+"', '"+R.drawable.american+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Ягодный"+"', '"+"Вода"+"', '"+false+"', '"+1150+"', '"+R.drawable.pngwing_com_4+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Ягодный"+"', '"+"Сахар"+"', '"+false+"', '"+1150+"', '"+R.drawable.pngwing_com_4+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Ягодный"+"', '"+"Ягоды"+"', '"+false+"', '"+1150+"', '"+R.drawable.pngwing_com_4+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Ягодный"+"', '"+"Сироп"+"', '"+false+"', '"+1150+"', '"+R.drawable.pngwing_com_4+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Ягодный"+"', '"+"Мята"+"', '"+false+"', '"+1150+"', '"+R.drawable.pngwing_com_4+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Имбирный"+"', '"+"Вода"+"', '"+false+"', '"+1150+"', '"+R.drawable.limonade_transparentes_fond_png+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Имбирный"+"', '"+"Имбирь"+"', '"+false+"', '"+1150+"', '"+R.drawable.limonade_transparentes_fond_png+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Имбирный"+"', '"+"Сахар"+"', '"+false+"', '"+1150+"', '"+R.drawable.limonade_transparentes_fond_png+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Имбирный"+"', '"+"Мята"+"', '"+false+"', '"+1150+"', '"+R.drawable.limonade_transparentes_fond_png+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Черный"+"', '"+"Вода"+"', '"+false+"', '"+900+"', '"+R.drawable.cherniy+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Черный"+"', '"+"Черный чай"+"', '"+false+"', '"+900+"', '"+R.drawable.cherniy+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Черный"+"', '"+"Сахар"+"', '"+false+"', '"+900+"', '"+R.drawable.cherniy+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Зеленый"+"', '"+"Вода"+"', '"+false+"', '"+900+"', '"+R.drawable.zeleniy+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Зеленый"+"', '"+"Зеленый чай"+"', '"+false+"', '"+900+"', '"+R.drawable.zeleniy+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Зеленый"+"', '"+"Сахар"+"', '"+false+"', '"+900+"', '"+R.drawable.zeleniy+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Ягодный"+"', '"+"Вода"+"', '"+false+"', '"+1450+"', '"+R.drawable.pngwing_com_6+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Ягодный"+"', '"+"Молоко"+"', '"+false+"', '"+1450+"', '"+R.drawable.pngwing_com_6+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Ягодный"+"', '"+"Ягоды"+"', '"+false+"', '"+1450+"', '"+R.drawable.pngwing_com_6+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Ягодный"+"', '"+"Банан"+"', '"+false+"', '"+1450+"', '"+R.drawable.pngwing_com_6+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Смородина"+"', '"+"Вода"+"', '"+false+"', '"+1450+"', '"+R.drawable.yagodniye+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Смородина"+"', '"+"Молоко"+"', '"+false+"', '"+1450+"', '"+R.drawable.yagodniye+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);
        SQLiteDataBaseQueryHolder = "INSERT INTO Menu_list (Kinds_of_menu,Ingredients,Heart,Price,Photo) VALUES('"+"Смородина"+"', '"+"Смородина"+"', '"+false+"', '"+1450+"', '"+R.drawable.yagodniye+"');";
        sqLiteDatabaseObj1.execSQL(SQLiteDataBaseQueryHolder);


    }
    public void deletetable(){
        sqLiteDatabaseObj1.delete("Menu_list", null, null);
    }
}
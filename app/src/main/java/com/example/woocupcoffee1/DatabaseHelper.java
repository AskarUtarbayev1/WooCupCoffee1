package com.example.woocupcoffee1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "Menu";
    private static final String COL1 = "ID";
    private static final String COL2 = "List_of_menu";
    private static final String COL3 = "Kinds_of_menu";
    private static final String COL4 = "Price";
    private static final String COL5 = "Photo";


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT ,"+COL3+" TEXT ,"+COL4+" INTEGER,"+COL5+" INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean insertContact (String list, String kinds, int price,int photo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("List_of_menu", "Кофе");
        contentValues.put("Kinds_of_menu", "Эспрессо");
        contentValues.put("Price", 6);
        contentValues.put("Photo",R.drawable.background11);

        db.insert("Menu", null, contentValues);
        return true;
    }

    public ArrayList<HashMap<String, String>> GetUsers(){

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT List_of_menu,Kinds_of_menu,Price,Photo FROM "+ TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("List_of_menu",cursor.getString(cursor.getColumnIndex(COL2)));
            user.put("Kinds_of_menu",cursor.getString(cursor.getColumnIndex(COL3)));
            user.put("Price",cursor.getString(cursor.getColumnIndex(COL4)));
            user.put("Photo",cursor.getString(cursor.getColumnIndex(COL5)));
            userList.add(user);
        }
        return  userList;
    }
}

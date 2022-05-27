package com.example.woocupcoffee1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import maes.tech.intentanim.CustomIntent;

public class Zakaz2 extends AppCompatActivity {
    TextView dostavka1,dostavka2,dostavka3,promejut,itog;
    ListView listView;
    MyAdapter adapter;
    CheckBox delivery;
    String name="";
    String call_number="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakaz2);
        listView = (ListView) findViewById(R.id.list_heart);
        String item[]=new String[1];
        item[0]=getIntent().getStringExtra("item");
        String price[]=new String[1];
        price[0]=getIntent().getStringExtra("price");
        Integer photo[]=new Integer[1];
        photo[0]=Integer.valueOf(getIntent().getStringExtra("photo"));
        listView = (ListView) findViewById(R.id.list_heart);
        adapter = new MyAdapter(this, price,item,photo);
        listView.setAdapter(adapter);
        delivery=findViewById(R.id.dostavka);
        dostavka1=findViewById(R.id.dostavka1);
        dostavka2=findViewById(R.id.dostavka2);
        dostavka3=findViewById(R.id.dostavka3);
        promejut=findViewById(R.id.promejut3);
        promejut.setText(getIntent().getStringExtra("price"));
        itog= findViewById(R.id.itog);
        int dostavka=Integer.parseInt(dostavka3.getText().toString());
        int promejut1=Integer.parseInt(promejut.getText().toString());
        int sum=dostavka+promejut1;
        itog.setText(Integer.toString(sum));

    }
    public void check(View view){
        CustomIntent.customType(this,"fadein-to-fadeout");
        int dostavka=Integer.parseInt(dostavka3.getText().toString());
        int promejut1=Integer.parseInt(promejut.getText().toString());
        int sum=dostavka+promejut1;
        if(delivery.isChecked()==true){
            dostavka1.setVisibility(View.VISIBLE);
            dostavka2.setVisibility(View.VISIBLE);
            dostavka3.setVisibility(View.VISIBLE);
            itog.setText(Integer.toString(sum));
        }
        else{
            dostavka1.setVisibility(View.INVISIBLE);
            dostavka2.setVisibility(View.INVISIBLE);
            dostavka3.setVisibility(View.INVISIBLE);
            itog.setText(Integer.toString(promejut1));
        }
    }
    public void zakazat(View view){
        String ati=getIntent().getStringExtra("item");
        String price=getIntent().getStringExtra("price");
        Integer photo=Integer.valueOf(getIntent().getStringExtra("photo"));
        name=getIntent().getStringExtra("name");
        call_number=getIntent().getStringExtra("call_number");
        if(name==null && call_number==null){
            Toast.makeText(Zakaz2.this, "Пожалуйста войдите в систему для заказа!", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Zakaz2.this,Voity.class);
            startActivity(intent);
            CustomIntent.customType(this,"fadein-to-fadeout");
        }
        else{
            Intent intent=new Intent(Zakaz2.this,Admin_zakaz.class);
            intent.putExtra("name",name);
            intent.putExtra("call_number",call_number);
            intent.putExtra("item",ati);
            intent.putExtra("price",price);
            intent.putExtra("photo",photo.toString());
            startActivity(intent);
            CustomIntent.customType(this,"fadein-to-fadeout");
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_layout_root));
            ImageView image = (ImageView) layout.findViewById(R.id.image);
            image.setImageResource(R.drawable.aaaaa);
            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }
    }

    public void backk(View view){
        Intent intent=new Intent(Zakaz2.this,Menu.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void Second(View view){
        Intent intent=new Intent(Zakaz2.this,Izbran.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void First(View view){
        Intent intent=new Intent(Zakaz2.this,Menu.class);
        startActivity(intent);
        CustomIntent.customType(this,"fadein-to-fadeout");
    }
    public void fourth(View view){
        if(name==null && call_number==null){
            Intent intent=new Intent(Zakaz2.this,Voity.class);
            startActivity(intent);
            CustomIntent.customType(this,"fadein-to-fadeout");
        }
        else{
            Intent intent=new Intent(Zakaz2.this,Users.class);
            startActivity(intent);
            CustomIntent.customType(this,"fadein-to-fadeout");
        }
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String sTitle[];
        String prices[];
        Integer mImage[];
        MyAdapter(Context c,String prices[], String title[],Integer imgs[]){
            super(c, R.layout.list_k, title);
            this.context = c;
            this.sTitle = title;
            this.mImage = imgs;
            this.prices=prices;
        }
        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = null;
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View exinthype  =  layoutInflater.inflate(R.layout.list_k, parent, false);
            ImageView imgView = exinthype.findViewById(R.id.image1);
            TextView txtView1 = exinthype.findViewById(R.id.text2);
            TextView txtView2 = exinthype.findViewById(R.id.text3);
//            Button button= exinthype.findViewById(R.id.image8);
//            final String temp = getItem(position);
//            button.setOnClickListener(
//                    new Button.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            onButtonClickListner(position,temp);
//
//                        }
//                    }
//            );
//
//            button.setTag(position);
            imgView.setImageResource(mImage[position]);
            txtView1.setText(sTitle[position]);
            txtView2.setText(prices[position]);


            return exinthype;
        }
//        public void onButtonClickListner(int position, String value) {
//            List<String> tempList = new ArrayList<String>(Arrays.asList(sTitle));
//            tempList.remove(position);
//            List<String> tempList1 = new ArrayList<String>(Arrays.asList(prices));
//            tempList1.remove(position);
//            List<Integer> tempList2 = new ArrayList<Integer>(Arrays.asList(mImage));
//            tempList2.remove(position);
//            Toast.makeText(Zakaz2.this, "Button click " + value, Toast.LENGTH_SHORT).show();
//
//        }

    }
}
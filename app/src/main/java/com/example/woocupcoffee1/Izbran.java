package com.example.woocupcoffee1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import maes.tech.intentanim.CustomIntent;

public class Izbran extends AppCompatActivity {
    ListView listView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izbran);
        String item[] = new String[1];
        item[0] = getIntent().getStringExtra("item");
        String price[] = new String[1];
        price[0] = getIntent().getStringExtra("price");
        int photo[] = new int[1];
        photo[0] = Integer.valueOf(getIntent().getStringExtra("photo"));
        listView = (ListView) findViewById(R.id.list_heart);
        adapter = new MyAdapter(this, price, item, photo);
        listView.setAdapter(adapter);
    }

    public void backk(View view) {
        Intent intent = new Intent(Izbran.this, Zakaz1.class);
        startActivity(intent);
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    public void Third(View view) {
        Intent intent = new Intent(Izbran.this, Zakaz2.class);
        startActivity(intent);
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    public void First(View view) {
        Intent intent = new Intent(Izbran.this, Menu.class);
        startActivity(intent);
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    public void fourth(View view) {
        String name="";
        String call_number="";
        name=getIntent().getStringExtra("name");
        call_number=getIntent().getStringExtra("call_number");
        if(name==null && call_number==null){
            Intent intent=new Intent(Izbran.this,Voity.class);
            startActivity(intent);
            CustomIntent.customType(this,"fadein-to-fadeout");
        }
        else{
            Intent intent=new Intent(Izbran.this,Users.class);
            startActivity(intent);
            CustomIntent.customType(this,"fadein-to-fadeout");
        }
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String sTitle[];
        String prices[];
        int mImage[];

        MyAdapter(Context c, String prices[], String title[], int imgs[]) {
            super(c, R.layout.list_k, R.id.text2, title);
            this.context = c;
            this.sTitle = title;
            this.mImage = imgs;
            this.prices = prices;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View exinthype = layoutInflater.inflate(R.layout.list_k, parent, false);
            ImageView imgView = exinthype.findViewById(R.id.image1);
            TextView txtView1 = exinthype.findViewById(R.id.text2);
            TextView txtView2 = exinthype.findViewById(R.id.text3);
//            ImageButton button = exinthype.findViewById(R.id.image8);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //do something
//                    adapter.clear(); //or some other task
//                    notifyDataSetChanged();
//                }
//            });

            imgView.setImageResource(mImage[position]);
            txtView1.setText(sTitle[position]);
            txtView2.setText(prices[position]);


            return exinthype;
        }
    }
}
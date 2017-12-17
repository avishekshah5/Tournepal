package com.avh.tour_dev;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class userlist extends AppCompatActivity {
    LinearLayout container;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlist);
        container= findViewById(R.id.container);
        databaseHelper=new DatabaseHelper(this);
        populatedata();
    }
    @SuppressLint("SetTextI18n")
    public void populatedata(){
        ArrayList<userinfo>list=databaseHelper.getUserlist();
        for(int i=0;i<list.size();i++){
            final userinfo info=list.get(i);
            TextView textview=new TextView(this);
            textview.setText(
            info.username+" ,"+info.address+"\n");
            @SuppressLint("InflateParams") View view= LayoutInflater.from(this).inflate(R.layout.itemlayout,null);
            TextView username,address,phone;
            username= view.findViewById(R.id.username);
            address= view.findViewById(R.id.address);

            username.setText(info.username);
            address.setText(info.address);
            view.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(userlist.this,userdetail.class);
                    intent.putExtra("id",info.id);
                    startActivity(intent);
                }
            });


            container.addView(view);

        }
    }

}

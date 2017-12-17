package com.avh.tour_dev;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class locationlist extends AppCompatActivity {
ListView listview;


DatabaseHelper databaseHelper;
    DatabaseHelperLocate databaseHelper1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationlist);
        databaseHelper=new DatabaseHelper(this);
        databaseHelper1 = new DatabaseHelperLocate(this);
        listview= findViewById(R.id.listview);
        listview.setAdapter(new locationlistadapter(this,databaseHelper1.getlocationlist()));


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.added:
                startActivity(new Intent(locationlist.this,addlocationactivity.class));
                break;

            case R.id.signout:
                startActivity(new Intent(locationlist.this,menu_activity.class));
                break;

            case R.id.accountset:
               showCustomDialog();
                break;
            case R.id.notification:
                //startActivity(new Intent(locationdetail.this,menu_activity.class));
                break;
            case R.id.trending:
                Toast.makeText(locationlist.this,"Origion developer Team",Toast.LENGTH_LONG).show();
                break;
            case R.id.nearby:
                Toast.makeText(locationlist.this,"Origion developer Team",Toast.LENGTH_LONG).show();
                break;
            case R.id.recommend:
                startActivity(new Intent(locationlist.this,recommendactivity.class));
                break;



        }
        return super.onOptionsItemSelected(item);
    }

    public void showCustomDialog(){
        final Dialog dialog=new Dialog(this);
        View view= LayoutInflater.from(this).inflate(R.layout.signin,null);
        dialog.setCancelable(true);
        dialog.setTitle("LOG IN");
        final EditText username,password;
        Button login;
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);
        login= findViewById(R.id.login2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernam=username.getText().toString();
                String passwor=password.getText().toString();
                if(usernam.isEmpty()){
                    username.setError("cannot be empty");
                }
                else if(passwor.isEmpty()){
                    password.setError("incorrect password");
                }
                else if(databaseHelper.isLoggedsucess(usernam,passwor)){
                    Intent intent1=new Intent(locationlist.this,adminactivity.class);
                    intent1.putExtra("username",usernam);
                    startActivity(intent1);
                    finish();
                }
                else
                {
                    showCustomTost();
                }
                dialog.dismiss();

            }
        });
        dialog.setContentView(view);
        dialog.show();

    }
    public  void showCustomTost(){
        Toast toast=new Toast(this);
        @SuppressLint("InflateParams") View view= LayoutInflater.from(this).inflate(R.layout.toasty,null);
        TextView message= view.findViewById(R.id.message);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

    }

        }




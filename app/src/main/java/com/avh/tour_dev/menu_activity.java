package com.avh.tour_dev;

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
import android.widget.TextView;
import android.widget.Toast;

public class menu_activity extends AppCompatActivity {
    private Button sign,log;
    EditText username1,password1;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        databaseHelper=new DatabaseHelper(this);
        username1= findViewById(R.id.username);
        password1= findViewById(R.id.password);
        log= findViewById(R.id.login2);
        sign= findViewById(R.id.signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(menu_activity.this,signupactivity.class);
                startActivity(intent);
            }
        });


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernam=username1.getText().toString();
                String passwor=password1.getText().toString();
                if(usernam.isEmpty()){
                    username1.setError("cannot be empty");
                }
                else if(passwor.isEmpty()){
                    password1.setError("incorrect password");
                }
                else if(databaseHelper.isLoggedsucess(usernam,passwor)){
                    showCustomTost("LOG IN SUCCESSFULL :) :)");
                    Intent intent1=new Intent(menu_activity.this,locationlist.class);

                    startActivity(intent1);
                    finish();
                }
                else
                {
                   showCustomTost("LOG IN FAILURE !!");
                }


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.admin:
                startActivity(new Intent(menu_activity.this,adminactivity.class));
                break;

            case R.id.developer:
                Toast.makeText(menu_activity.this,"For Developer option Please ROOT Your Device",Toast.LENGTH_LONG).show();
                break;
           case R.id.privacy:
               Toast.makeText(menu_activity.this,"Please Download Terms And Conditon From Website",Toast.LENGTH_LONG).show();
                break;
            case R.id.aboutus:
               showCustomTost("NCE BCT071 105");
                break;


        }
        return super.onOptionsItemSelected(item);
    }
    public  void showCustomTost(String messagevalue){
        Toast toast=new Toast(this);
        View view= LayoutInflater.from(this).inflate(R.layout.toasty,null);
        TextView message= view.findViewById(R.id.message);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

    }

}

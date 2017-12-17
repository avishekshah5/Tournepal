package com.avh.tour_dev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminactivity extends AppCompatActivity {
    private Button adminlogin;
    EditText name,password,devid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        name= findViewById(R.id.adminname);
        password= findViewById(R.id.adminpassword);
        devid= findViewById(R.id.adminid);

        adminlogin= findViewById(R.id.admin1login);
        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aname=name.getText().toString();
                String apassword=password.getText().toString();
                String aid=devid.getText().toString();
                if(aname.isEmpty()){
                   name.setError("cannot be empty");
                }
               else if(aname.isEmpty()){
                    password.setError("incorrect password");
                }
                else if(aid.isEmpty()){
                    devid.setError("incorrect Developer Id");
                }



                else if(aname.equals("avsh") && apassword.equals("avsh1234")&& aid.equals("9860622353"))
                {
                    Intent intent1=new Intent(adminactivity.this,adminview.class);
                    startActivity(intent1);
                }
                else
                {
                    Toast.makeText(adminactivity.this,"Log in failure!!",Toast.LENGTH_LONG).show();
               }

            }
        });
    }
}

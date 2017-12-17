package com.avh.tour_dev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminview extends AppCompatActivity {
    private Button userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminviewactivity);
        userlist= findViewById(R.id.userlist);
        userlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(adminview.this,userlist.class);

                startActivity(intent);
            }
        });

    }
}

package com.avh.tour_dev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import static android.R.attr.animation;

public class startupActivity extends AppCompatActivity {
    ImageView icon;
    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startupactivity);
        icon= findViewById(R.id.ticon);
        anim= AnimationUtils.loadAnimation(this,R.anim.anim);

        icon.setAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent=new Intent(startupActivity.this,menu_activity.class);
                        startActivity(intent);
                 finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}

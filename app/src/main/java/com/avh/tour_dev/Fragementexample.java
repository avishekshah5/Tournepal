package com.avh.tour_dev;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.avh.tour_dev.fragement.bottomFragement;
import com.avh.tour_dev.fragement.locationFragement;
import com.avh.tour_dev.fragement.topFragement;

public class Fragementexample extends AppCompatActivity {
    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragementexample);
        viewpager= findViewById(R.id.viewpager);
        viewpager.setAdapter(new viewpageradapter(getSupportFragmentManager()));


    }
    public class viewpageradapter extends FragmentPagerAdapter{

        public viewpageradapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                 return new topFragement();

                case 1:
                    return  new locationFragement();






            }
            return  new bottomFragement();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}

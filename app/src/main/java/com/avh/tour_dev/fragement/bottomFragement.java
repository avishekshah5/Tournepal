package com.avh.tour_dev.fragement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.avh.tour_dev.DatabaseHelperLocate;
import com.avh.tour_dev.R;
import com.avh.tour_dev.locationinfo;


/**
 * Created by ${avishek_shahi} on ${2017}.
 */


public class bottomFragement extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
DatabaseHelperLocate databasehelper2;
    String id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        @SuppressLint("InflateParams") View view=inflater.inflate(R.layout.locationdetail2,null);
        id= getActivity().getIntent().getStringExtra("id");
        databasehelper2=new DatabaseHelperLocate(getActivity());
        locationinfo info=databasehelper2.getselectedlocation(id);
        TextView nview= view.findViewById(R.id.featureinfo);
        nview.setText(info.feature);
        TextView nview2= view.findViewById(R.id.routeinfo);
        nview2.setText(info.route);
        TextView nview3= view.findViewById(R.id.addedinfo);
        nview3.setText(info.addedby);
        return view;
    }
}

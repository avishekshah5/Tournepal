package com.avh.tour_dev.fragement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.avh.tour_dev.DatabaseHelperLocate;
import com.avh.tour_dev.R;
import com.avh.tour_dev.addlocationactivity;
import com.avh.tour_dev.locationinfo;

import static android.R.attr.description;

/**
 * Created by AVSH SHAH on 2/17/2017.
 */

public class topFragement extends Fragment {

      @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    DatabaseHelperLocate databaseHelper12;
    String id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        @SuppressLint("InflateParams") View view=inflater.inflate(R.layout.locationdetail,null);
        id= getActivity().getIntent().getStringExtra("id");

        databaseHelper12=new DatabaseHelperLocate(getActivity());

        locationinfo info=databaseHelper12.getselectedlocation(id);

        ImageView image= view.findViewById(R.id.imge1);

        image.setImageBitmap(addlocationactivity.getBitmap(info.image1));

        ImageView image2= view.findViewById(R.id.imge2);

        image2.setImageBitmap(addlocationactivity.getBitmap(info.image2));
        TextView desc= view.findViewById(R.id.locationinfo);
        desc.setText(info.locationname);
        TextView nameview3= view.findViewById(R.id.addressinfo1);
        nameview3.setText(info.address);


        return view;
    }


}

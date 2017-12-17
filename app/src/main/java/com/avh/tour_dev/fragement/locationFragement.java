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

public class locationFragement extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    DatabaseHelperLocate databaseHelperLocate1;
    Context context1;
    String id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        @SuppressLint("InflateParams") View view=inflater.inflate(R.layout.locationdetail1,null);
        id= getActivity().getIntent().getStringExtra("id");
        databaseHelperLocate1=new DatabaseHelperLocate(getActivity());
        locationinfo info=databaseHelperLocate1.getselectedlocation(id);

        TextView description = view.findViewById(R.id.descriptioninfo);
        description.setText(info.description);

        TextView nview1= view.findViewById(R.id.accomodationinfo);
        nview1.setText(info.accomodation);

        return view;
    }
}

package com.example.nocturnal.swapingtab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class firstFragment extends Fragment {

    private String city;
    private TextView city_nameTV;


    public firstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_first, container, false);

        city_nameTV = (TextView) v.findViewById(R.id.city_name);
        //city_nameTV.setText("city");
        //city_nameTV.setText(getArguments().getString("country"));
        //getArguments().getString("country");

        return v;
    }

}

package com.example.sih;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class fragment_four extends Fragment {
    TextView t;
    String crop;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_four, container, false);
        crop=MainActivity.result;
        /*if(crop.equals("Cotton")) {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Location");
        }
        if(crop.equals("Sugarcane"))
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Location");
        }*/
        t = view.findViewById(R.id.someTextView);  //UPDATE
        t.setText("Location");
        return view;

    }
}

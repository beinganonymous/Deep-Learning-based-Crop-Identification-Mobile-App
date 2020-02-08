package com.example.sih;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class fragment_three extends Fragment {
    private static final int ADDMEETING_REQUEST = 1;
    TextView t;
    String crop;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three,
                container, false);
        crop = MainActivity.result;
        if(crop.equals("Cotton")) {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Soil:\n" +
                    "Sandy loam\n" +
                    "Yellowish-red sandy clay\n" +
                    "Loamy sand \n");
        }
        if(crop.equals("Sugarcane"))//sugercane
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Soil:\n" +
                    "Sandy\n" +
                    "Loamy\n" +
                    "Clay soils\n" +
                    "Acidic and Alkaline soils\n");
        }
        if(crop.equals("Watermelon"))//watermelon
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Soil:\n" +
                    "Watermelons grow best in sandy loam soil\n" +
                    "Black soil and \n" +
                    "Sandy soil\n");
        }
        if(crop.equals("Wheat"))//wheat
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Soil:\n" +
                    " Loam soil\n" +
                    " Clay\n" +
                    " Sandy or heavy loam. \n");
        }
        /*if(crop.equals("Sugarcane"))//potato
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Soil:\n" +
                    " Saline\n" +
                    "Alkaline soils\n" +
                    "Loamy and sandy loam soils\n");
        }
        if(crop.equals("Sugarcane"))//soyabean
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Soil:\n" +
                    "Well-drained, Loamy Soil\n" +
                    "Silt soil\n" +
                    "Clay soil\n");
        }*/
        if(crop.equals("Rice"))//rice
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Soil:\n" +
                    "Riverine alluvium\n" +
                    " Red-yellow\n" +
                    "Terai\n" +
                    " Laterite\n" +
                    "Mixed red and black and medium and shallow black soils.\n");
        }
        if(crop.equals("Bajra"))//bajara
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Soil:\n" +
                    "Light sandy soils\n" +
                    "Black and red soils\n" +
                    "Upland gravely soils\n");
        }
        return view;
    }
}
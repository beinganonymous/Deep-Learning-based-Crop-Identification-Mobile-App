package com.example.sih;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class fragment_two extends Fragment {
    private static final int ADDMEETING_REQUEST = 1;
    TextView t;
    String crop;
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two,
                container, false);
        crop = MainActivity.result;
        if(crop.equals("Cotton")) {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Temperature:\n" +
                    "Cotton grows in tropical and sub-tropical warm humid climate. Annual temperature requirement is 20°-28°C. Equitable temper¬ature distribution and bright sunshine is desirable.\n");
        }
        if(crop.equals("Sugarcane"))//sugercane
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Temperature:\n" +
                    "Sugarcane is a tropical plant, therefore, requires a year warm weather to reach maturity. The areas having temperature of 20° to 26°C and an average rainfall of 150 cm are suitable for its cultivation.");
        }
        if(crop.equals("Watermelon"))//watermelon
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Temperature:\n" +
                    "Optimum temperatures for watermelons are around 26-28°C (around 80° Fahrenheit). Temperatures below 12°C (54°F) and above 40°C (104°F) will stop plants' growth. Also, watermelons are very sensitive to frost and such temperatures can kill not only its vines, but entire plants.");
        }
        /*if(crop.equals("Sugarcane"))//soyabean
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Temperature:\n" +
                    "The temperature ranging from 26.5 to 30°C is considered favorable for most of the soyabean varieties. It requires a minimum 15.5°C soil temperature for rapid germination and growth. ");
        }*/
        if(crop.equals("Wheat"))//wheat
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Temperature:\n" +
                    "The temperature required for wheat during growing season is around 15.5°C. The average temperature of the hottest month should not exceed 20°C. A frost-free period of 100 days is usually required but some fast-ripening varieties may mature only in 90 days.");
        }
        /*if(crop.equals("Sugarcane"))//potato
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Temperature:\n" +
                    "Growing potatoes requires cool climate. Potatoes grow best in temperature of 15-20(°C). Nevertheless, it has the ability to adapt to a wide range of climate conditions.\n" +
                    "\n");
        }*/
        if(crop.equals("Rice"))//rice
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Temperature:\n" +
                    "Rice is a tropical crop and grown where the average temperature during the growing season is between 20°C and 27°C.");
        }
        if(crop.equals("Cabbage"))//cabbage
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Temperature:\n" +
                    " A temperature range of 15o-21o C is considered as optimum for growth and head formation of the crop. The intensity of flowering depends upon the age of the plants and the period for which they are exposed to low temperatures.");
        }
        if(crop.equals("Bajra"))//bajara
        {
            t = view.findViewById(R.id.someTextView);  //UPDATE
            t.setText("Temperature:\n" +
                    "A temperature range of 20-30°C is best for its growth. It performs well in soils with high salinity or low pH. Because of its tolerance to difficult growing conditions, it can be grown in areas where other cereal crops, such as maize or wheat, would not survive.");
        }
        return view;
    }
}
package com.example.sih;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CropDetails extends AppCompatActivity {

    String res,detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_detail);

        res = MainActivity.result;
        ImageView img = findViewById(R.id.uploaded_image);
        img.setImageBitmap(MainActivity.bitmap);
        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        detail = sharedpreferences.getString(res,"");
        //String accuracy_Per=sharedpreferences.getString(perc,"");
        TextView crop_detail= findViewById(R.id.crop_details);
        crop_detail.setText(detail+ "\nAccuracy : " +MainActivity.perc);
        Button moreinfo=findViewById(R.id.getmore_info);
        moreinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent three_tab = new Intent(CropDetails.this, threetab_slider.class);
                startActivity(three_tab);
                finish();
            }
        });

    }
}

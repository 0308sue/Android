package com.example.myapp07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity2_rating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_rating);

        RatingBar ratingBar1,ratingBar2,ratingBar3;
        Button btn1,btn2;

        ratingBar1 = findViewById(R.id.ratingBar1);
        ratingBar2 = findViewById(R.id.ratingBar2);
        ratingBar3 = findViewById(R.id.ratingBar3);

        btn1 = findViewById(R.id.btnInc);
        btn2 = findViewById(R.id.btnDec);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingBar1.setRating(ratingBar1.getRating()+ratingBar1.getStepSize());
                ratingBar2.setRating(ratingBar2.getRating()+ratingBar2.getStepSize());
                ratingBar3.setRating(ratingBar3.getRating()+ratingBar3.getStepSize());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ratingBar1.setRating(ratingBar1.getRating()-ratingBar1.getStepSize());
                ratingBar2.setRating(ratingBar2.getRating()-ratingBar2.getStepSize());
                ratingBar3.setRating(ratingBar3.getRating()-ratingBar3.getStepSize());
            }
        });

    }
}
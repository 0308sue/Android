package com.example.myapp07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity2_pic_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_pic_second);

        setTitle("투표결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("voteCount");
        String [] ImageResult = intent.getStringArrayExtra("imgName");
        Integer imageId[]={
                R.drawable.pic1, R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9
        };

        TextView tvTop = findViewById(R.id.tvTop);
        ImageView ivTop = findViewById(R.id.ivTop);

        int maxPos = 0;
        for(int i = 0;i<voteResult.length;i++){
            if (voteResult[maxPos] < voteResult[i]) {
                maxPos = i;
            }
        }
        tvTop.setText(ImageResult[maxPos]+"("+voteResult[maxPos]+")");
        ivTop.setImageResource(imageId[maxPos]);

        TextView tv[] = new TextView[ImageResult.length];
        RatingBar rbar[] = new RatingBar[ImageResult.length];

        Integer tvId[] = { R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};

        Integer rbarId[] = {R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};

        for(int i = 0;i<voteResult.length;i++){
            tv[i] = findViewById(tvId[i]);
            rbar[i] =  findViewById(rbarId[i]);
        }

        for (int i = 0; i<voteResult.length;i++){
            tv[i].setText(ImageResult[i]);
            rbar[i].setRating(voteResult[i]);
        }

        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
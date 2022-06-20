package com.example.myapp07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2_pic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_pic);

        Button btnResult = findViewById(R.id.btnResult);
        int voteCount[] = new int[9];
        ImageView image[] = new ImageView[9];
        Integer imageId[]={
                R.id.iv1, R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9
        };
        String imgName[]={
                "pic1","pic2","pic3","pic4","pic5","pic6","pic7","pic8","pic9"
        };
        for(int i = 0; i<imageId.length;i++){
            final int index = i;
            image[index] = findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgName[index]+" 총 : "+voteCount[index]+"표",Toast.LENGTH_SHORT).show();
                }
            });
        }

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2_pic.this,
                        MainActivity2_pic_second.class);

                intent.putExtra("voteCount",voteCount);
                intent.putExtra("imgName",imgName);
                startActivity(intent);
            }
        });
    }
}
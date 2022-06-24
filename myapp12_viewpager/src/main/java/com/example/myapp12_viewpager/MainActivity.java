package com.example.myapp12_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    Button btnToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        btnToggle = findViewById(R.id.btnToggle);

        ArrayList<DataPage> list = new ArrayList<>();
        list.add(new DataPage(Color.YELLOW,"1Page"));
        list.add(new DataPage(Color.BLUE,"2Page"));
        list.add(new DataPage(Color.GREEN,"3Page"));
        list.add(new DataPage(Color.MAGENTA,"4Page"));
        list.add(new DataPage(Color.LTGRAY,"5Page"));
        list.add(new DataPage(Color.CYAN,"6Page"));
        viewPager2.setAdapter(new ViewPagerAdapter(list));

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager2.getOrientation() == ViewPager2.ORIENTATION_VERTICAL) {
                    btnToggle.setText("가로로 슬라이드");
                    viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                }
            else{
                btnToggle.setText("세로로 슬라이드");
                viewPager2.setOrientation(viewPager2.ORIENTATION_VERTICAL);
            }
            }
        });
    }
}
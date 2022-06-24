package com.example.myapp12_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import me.relex.circleindicator.CircleIndicator3;

public class Main2ViewpagerActivity extends AppCompatActivity {
    private ViewPager2 mpager;
    private FragmentStateAdapter fragmentStateAdapter;
    private int num_page = 4;
    private CircleIndicator3 circleIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_viewpager);

        mpager = findViewById(R.id.viewpager);
        fragmentStateAdapter = new MyFragAdapter(this,num_page);
        mpager.setAdapter(fragmentStateAdapter);

        circleIndicator = findViewById(R.id.indicator);
        circleIndicator.setViewPager(mpager);
        circleIndicator.createIndicators(num_page,0);

        mpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mpager.setCurrentItem(0);
        mpager.setOffscreenPageLimit(3);

        mpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                if (positionOffsetPixels == 0 ){
//                    mpager.setCurrentItem(0);
//                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                circleIndicator.animatePageSelected(position%num_page);
            }
        });
    }
}
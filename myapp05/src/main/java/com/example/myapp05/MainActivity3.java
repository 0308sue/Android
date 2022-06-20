package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity3 extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecPeach = tabHost.newTabSpec("PEACH").setIndicator("복숭아");
        tabSpecPeach.setContent(R.id.tabPeach);
        tabHost.addTab(tabSpecPeach);

        TabHost.TabSpec tabSpecApple = tabHost.newTabSpec("APPLE").setIndicator("사과");
        tabSpecApple.setContent(R.id.tabApple);
        tabHost.addTab(tabSpecApple);

        TabHost.TabSpec tabSpecOrange = tabHost.newTabSpec("ORANGE").setIndicator("오렌지");
        tabSpecOrange.setContent(R.id.tabOrange);
        tabHost.addTab(tabSpecOrange);

        TabHost.TabSpec tabSpecMANGO = tabHost.newTabSpec("MANGO").setIndicator("망고");
        tabSpecMANGO.setContent(R.id.tabMango);
        tabHost.addTab(tabSpecMANGO);

        tabHost.setCurrentTab(0);
    }
}
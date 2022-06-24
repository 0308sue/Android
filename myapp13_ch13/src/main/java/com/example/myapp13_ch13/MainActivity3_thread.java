package com.example.myapp13_ch13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity3_thread extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_thread);

        ProgressBar pb1 = findViewById(R.id.pb1);
        SeekBar pb2 = findViewById(R.id.pb2);
        Button btn = findViewById(R.id.btn1);
        TextView tvSeek = findViewById(R.id.tvSeek);
        TextView tvProgress = findViewById(R.id.tvProgress);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        for (int i = pb1.getProgress(); i < 100; i += 2) {
                            pb1.setProgress(i);
                            tvProgress.setText("진행률 p : "+ i+"%");
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

                new Thread() {
                    @Override
                    public void run() {
                        for (int i = pb2.getProgress(); i < 100; i ++ ) {
                            pb2.setProgress(i);
                            tvSeek.setText("진행률 s : "+ i+"%");
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });



    }
}
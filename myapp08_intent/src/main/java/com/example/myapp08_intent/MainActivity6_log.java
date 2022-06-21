package com.example.myapp08_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity6_log extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity6_log);

        setTitle("액티비티 life cycle 예제");
        Log.i("life cycle : ","onCreate()");

        Button btnDial = findViewById(R.id.btnDial);
        Button btnFinish = findViewById(R.id.btnFinish);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:010-1234:5678");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("life cycle onStart : ","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("life cycle onResume : ","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("life cycle onPause : ","onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("life cycle onRestart : ","onRestart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("life cycle onStop : ","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("life cycle onDestroy : ","onDestroy()");
    }
}
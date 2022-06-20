package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBox = findViewById(R.id.checkbox);
         btn1 = findViewById(R.id.btn1);
         btn2 = findViewById(R.id.btn2);

        checkBox.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == btn1){
            Toast.makeText(getApplicationContext(),"Button1",Toast.LENGTH_SHORT).show();
        }
        else if(view == btn2){
            Toast.makeText(getApplicationContext(),"Button2",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"선택!",Toast.LENGTH_SHORT).show();
        }
    }
}
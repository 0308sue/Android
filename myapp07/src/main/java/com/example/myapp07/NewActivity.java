package com.example.myapp07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class NewActivity extends AppCompatActivity {
RadioButton radioButton1,radioButton2,radioButton3;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        radioButton1 = findViewById(R.id.RdoSeceond);
        radioButton2 = findViewById(R.id.RdoThird);
        radioButton3 = findViewById(R.id.RdoForth);
        button = findViewById(R.id.btnnew);

        button.setOnClickListener(new View.OnClickListener() {
            Intent intent = null;
            @Override
            public void onClick(View view) {
                if (radioButton1.isChecked()){
                     intent = new Intent(getApplicationContext(),SecondAction.class);
                }else if(radioButton3.isChecked()){
                    intent = new Intent(getApplicationContext(),forth.class);
                }else {
                    intent = new Intent(getApplicationContext(),Third.class);
                }
                startActivity(intent);
            }
        });
    }
}
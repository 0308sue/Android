package com.example.myapp07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity3_return_sub extends AppCompatActivity {
    int Result = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_return_sub);

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("Num1",0);
        int num2 = intent.getIntExtra("Num2",0);
        int cal = intent.getIntExtra("cal",0);


        switch (cal){
            case R.id.Add:
                Result = num1+num2;
                break;
            case R.id.Min:
                Result = num1-num2;
                break;
            case R.id.Mul:
                Result = num1*num2;
                break;
            case R.id.Div:
                Result = num1/num2;
                break;
        }


        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retIntnent = new Intent(getApplicationContext(),MainActivity3_return.class);
                retIntnent.putExtra("Result",Result);
                setResult(RESULT_OK,retIntnent);
                finish();
            }
        });
    }
}
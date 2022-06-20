package com.example.myapp032;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText num1,num2;
    Button btnp,btnm,btnt,btnd,btnl;
    TextView result;
    String Num1,Num2;
    Double Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnp = findViewById(R.id.btnp);
        btnm = findViewById(R.id.btnm);
        btnt = findViewById(R.id.btnt);
        btnd = findViewById(R.id.btnd);
        btnl = findViewById(R.id.btnl);
        result = findViewById(R.id.result);


        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Num1 = num1.getText().toString();
                Num2 = num2.getText().toString();
                if(Num1.trim().equals("")||Num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "입력 값이 비어있습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Result= Double.parseDouble(Num1)+Double.parseDouble(Num2);
                result.setText(Result.toString());
            }
        });

        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Num1 = num1.getText().toString();
                Num2 = num2.getText().toString();
                if(Num1.trim().equals("")||Num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "입력 값이 비어있습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Result= Double.parseDouble(Num1)-Double.parseDouble(Num2);
                result.setText(Result.toString());
            }
        });

        btnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Num1 = num1.getText().toString();
                Num2 = num2.getText().toString();
                if(Num1.trim().equals("")||Num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "입력 값이 비어있습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Result= Double.parseDouble(Num1)*Double.parseDouble(Num2);
                result.setText(Result.toString());
            }
        });

        btnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Num1 = num1.getText().toString();
                Num2 = num2.getText().toString();
                if(Num1.trim().equals("")||Num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "입력 값이 비어있습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Result= Double.parseDouble(Num1)/Double.parseDouble(Num2);
                result.setText(Result.toString());
            }
        });

        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Num1 = num1.getText().toString();
                Num2 = num2.getText().toString();
                if(Num1.trim().equals("")||Num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "입력 값이 비어있습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Result= Double.parseDouble(Num1)%Double.parseDouble(Num2);
                result.setText(Result.toString());
            }
        });
    }
}
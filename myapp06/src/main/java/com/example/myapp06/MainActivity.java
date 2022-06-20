package com.example.myapp06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    Button btnWirte,btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnWirte =  findViewById(R.id.btnWrite);
        btnRead =  findViewById(R.id.btnRead);

        btnWirte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outputStream = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = "쿡북 안드로이드";
                    outputStream.write(str.getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(),"file.txt 생성됨",Toast.LENGTH_LONG).show();
                }catch (IOException e){

                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inputStream = openFileInput("file.txt");
                    byte[] txt = new byte[30];
                    inputStream.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
                }catch (IOException e){
                    Toast.makeText(getApplicationContext(),"파일 없음",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
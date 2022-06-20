package com.example.myapp06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class MainActivity2_diary extends AppCompatActivity {

    DatePicker dp;
    EditText edtDiary;
    Button btnWriter;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_diary);

        setTitle("간단 일기장");

        dp = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnWriter = findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year)+"_"+Integer.toString(monthOfYear)+"_"+Integer.toString(dayOfMonth)+".txt";

                //edtDiary.setText(readDiary(fileName));
                readDiary2(fileName);
                btnWriter.setEnabled(true);
            }
        });

        btnWriter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    outputStream.write(edtDiary.getText().toString().getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(),fileName+"이 저장됨",Toast.LENGTH_LONG).show();
                }catch (IOException e){

                }
            }
        });

    }

//    private String readDiary(String fileName) {
//        String diaryStr = null;
//        try {
//            FileInputStream inputStream = openFileInput(fileName);
//            byte[] txt = new byte[500];
//            inputStream.read(txt);
//            inputStream.close();
//            diaryStr = (new String(txt)).trim();
//        }catch (IOException e){
//            edtDiary.setHint("읽기 없음");
//            btnWriter.setText("새로 저장");
//        }
//        return diaryStr;
//    }

    private void readDiary2(String fileName) {
        String diaryStr = null;
        try {
            FileInputStream inputStream = openFileInput(fileName);
            byte[] txt = new byte[500];
            inputStream.read(txt);
            inputStream.close();
            diaryStr = (new String(txt)).trim();
            edtDiary.setText(diaryStr);
        }catch (IOException e){
            edtDiary.setHint("읽기 없음");
            btnWriter.setText("새로 저장");
        }
    }
}
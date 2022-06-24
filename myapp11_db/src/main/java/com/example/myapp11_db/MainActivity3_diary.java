package com.example.myapp11_db;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity3_diary extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    DatePicker dp;
    EditText edtDiary;
    Button btnWriter;
    MyDbHelper myDbHelper;
    String Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_diary);
        setTitle("간단 일기장");

        dp = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnWriter = findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        myDbHelper = new MyDbHelper(this);
        sqLiteDatabase = myDbHelper.getWritableDatabase();
        myDbHelper.onUpgrade(sqLiteDatabase, 1, 2);

        Date = Integer.toString(cYear)+"_"+Integer.toString(cMonth+1)+"_"+Integer.toString(cDay);
        String str = readDiary2(Date);
        edtDiary.setText(str);
        btnWriter.setEnabled(true);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                Date = Integer.toString(year)+"_"+Integer.toString(monthOfYear+1)+"_"+Integer.toString(dayOfMonth);
                String str = readDiary2(Date);
                edtDiary.setText(str);
                btnWriter.setEnabled(true);
            }
        });

        btnWriter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnWriter.getText().toString()=="새로저장"){
                    sqLiteDatabase = myDbHelper.getWritableDatabase();
                    String sql = "insert into myDiary values('"+Date+"',"+edtDiary.getText().toString()+");";
                    sqLiteDatabase.execSQL(sql);
                    sqLiteDatabase.close();
                    Toast.makeText(getApplicationContext(),"새로 저장 호출",Toast.LENGTH_LONG).show();
                }else{
                    sqLiteDatabase = myDbHelper.getWritableDatabase();
                    sqLiteDatabase.execSQL("UPDATE myDiary SET content ='"+edtDiary.getText().toString()+"' where diaryDate = '"+ Date +"';");
                    sqLiteDatabase.close();
                    Toast.makeText(getApplicationContext(),"수정됨",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    private String readDiary2(String Date) {
        String diaryStr = null;
        sqLiteDatabase = myDbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from myDiary where diaryDate = '"+Date+"';",null);
        if (cursor.getCount()==0){
            edtDiary.setHint("읽기 없음");
            btnWriter.setText("새로 저장");
        }else{
            cursor.moveToNext();
            diaryStr = cursor.getString(1);
            btnWriter.setText("수정하기");
             sqLiteDatabase.close();
        }
        return diaryStr;
    };

    public class MyDbHelper extends SQLiteOpenHelper{
        public MyDbHelper(Context context) {
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Toast.makeText(getApplicationContext(), "onCreate 호출", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL("create table if not exists myDiary(diaryDate char(10) primary key,content varchar(500));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            Toast.makeText(getApplicationContext(), "onUpgrade 호출", Toast.LENGTH_SHORT).show();
            onCreate(sqLiteDatabase);
        }
    }
}
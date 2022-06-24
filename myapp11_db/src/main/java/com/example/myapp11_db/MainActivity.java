package com.example.myapp11_db;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        EditText edDB,edTable;
        Button btnDB,btnTable,btnSelect,btnInsert;
        SQLiteDatabase sqLiteDatabase;
        TextView textView;
        String tablename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edDB = findViewById(R.id.edDB);
        edTable = findViewById(R.id.edTable);
        btnDB = findViewById(R.id.btnDB);
        btnTable = findViewById(R.id.btnTable);
        btnSelect = findViewById(R.id.btnSelect);
        btnInsert = findViewById(R.id.btnInsert);
        textView = findViewById(R.id.textView);

        btnDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                sqLiteDatabase = openOrCreateDatabase(edDB.getText().toString(),MODE_PRIVATE,null);
                output("데이터베이스:::"+edDB.getText().toString());
            }
        });

        btnTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                tablename = edTable.getText().toString();
                if(sqLiteDatabase == null ){
                    output("데이터베이스 생성하세요");
                    return;
                }
                String sql = "create table if not exists "+ tablename+"( id integer primary key autoincrement,name text,age integer, phone text)";
                sqLiteDatabase.execSQL(sql);
                output("테이블 생성 :: "+ tablename );
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                if(sqLiteDatabase == null ){
                    output("데이터베이스 생성하세요");
                    return;
                }
                if(tablename == null ){
                    output("테이블 생성하세요");
                    return;
                }
                output("btnSelect 호출");
                String sql = "select * from "+tablename;
                Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
//                for(int i = 0; i<cursor.getCount();i++){
//                    cursor.moveToNext();
//                    int id = cursor.getInt(0);
//                    String name = cursor.getString(1);
//                    int age = cursor.getInt(2);
//                    String phone = cursor.getString(3);
//                    output(id+"//"+name+"//"+age+"//"+phone);
//                }
                while (cursor.moveToNext()){
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    int age = cursor.getInt(2);
                    String phone = cursor.getString(3);
                    output(id+"||"+name+"||"+age+"||"+phone);
                }
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                if(sqLiteDatabase == null ){
                    output("데이터베이스 생성하세요");
                    return;
                }
                if(tablename == null ){
                    output("테이블 생성하세요");
                    return;
                }
                output("btnInsert 호출");
                String sql = "insert into "+tablename+"(name,age,phone) values('안드로이드',22,'010-7701-1381')";
                sqLiteDatabase.execSQL(sql);
                output("안드로이드 추가");
            }
        });

    }

    public void output(String str){
        textView.append(str+"\n");
    }
}
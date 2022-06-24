package com.example.myapp11_db;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2_db2 extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    TextView editNameResult,editNumberResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_db2);
        setTitle("가수 그룹 관리 DB");

        Button btnInit = findViewById(R.id.btnInit);
        Button btnInsert = findViewById(R.id.btnInsert);
        Button btnSelect = findViewById(R.id.btnSelect);
        Button btnTest = findViewById(R.id.btnTest);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnUpdate = findViewById(R.id.btnUpdate);

        EditText editName = findViewById(R.id.edName);
        EditText editNumber = findViewById(R.id.edNumber);
        editNameResult = findViewById(R.id.edtNameResult);
        editNumberResult = findViewById(R.id.edtNumberResult);
        MyDBHelper myDBHelper = new MyDBHelper(this);

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = myDBHelper.getWritableDatabase();
                myDBHelper.onUpgrade(sqLiteDatabase,1,2);
                sqLiteDatabase.close();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = myDBHelper.getWritableDatabase();
               // String sql = "insert into groupTBL values('"+editName.getText().toString()+"',"+editNumber.getText().toString()+");";
                String sql = "insert into groupTBL values(?,?)";
                SQLiteStatement statement =sqLiteDatabase.compileStatement(sql);
                String nameValue = editName.getText().toString();
                String numValue = editNumber.getText().toString();

                statement.bindString(1,nameValue);
                statement.bindString(2,numValue);
                statement.execute();

                //sqLiteDatabase.execSQL(sql);
                sqLiteDatabase.close();
                Toast.makeText(getApplicationContext(), "입력 됨", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = null;
                int Number = 0;
                sqLiteDatabase = myDBHelper.getReadableDatabase();
                Cursor cursor = sqLiteDatabase.rawQuery("select * from groupTBL",null);
                String strName = "그룹이름 : \n";
                String strNumber = "인원 : \n";
                while (cursor.moveToNext()){
                    strName += cursor.getString(0)+"\n";
                    strNumber += cursor.getInt(1)+"\n";
                }
                editNameResult.setText(strName);
                editNumberResult.setText(strNumber);
                cursor.close();
                sqLiteDatabase.close();
            }
        });

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringValue = "hello";

                sqLiteDatabase = myDBHelper.getWritableDatabase();
                sqLiteDatabase.beginTransaction();
                String sql= "insert into groupTBL(gname,gnumber) values(?,?)";
                SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);

                for (int i = 0;i<10;i++){
                    statement.clearBindings();
                    statement.bindString(1,stringValue+i);
                    statement.bindLong(2,i);
                    statement.executeInsert();
                }
                sqLiteDatabase.setTransactionSuccessful();
                sqLiteDatabase.endTransaction();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = myDBHelper.getWritableDatabase();
                String sql = "update groupTBL set gnumber = ? where gname = ?;";
                SQLiteStatement statement = sqLiteDatabase.compileStatement(sql);

                statement.bindString(1,editNumber.getText().toString());
                statement.bindString(2,editName.getText().toString());
                statement.execute();

                sqLiteDatabase.execSQL(sql);
                sqLiteDatabase.close();
                Toast.makeText(getApplicationContext(), "수정 됨", Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = myDBHelper.getWritableDatabase();
                String sql = "delete from groupTBL where gname = '"+editName.getText().toString()+"';";
                sqLiteDatabase.execSQL(sql);
                sqLiteDatabase.close();
                Toast.makeText(getApplicationContext(), "삭제 됨", Toast.LENGTH_SHORT).show();
                btnSelect.callOnClick();
            }
        });
    }
    public class  MyDBHelper extends SQLiteOpenHelper{

        public MyDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("create table groupTBL(gName char(20) primary key,gNumber integer);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("Drop table if exists groupTBL");
            onCreate(sqLiteDatabase);
        }
    }
}
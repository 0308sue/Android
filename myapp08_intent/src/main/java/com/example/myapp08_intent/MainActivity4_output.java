package com.example.myapp08_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4_output extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_output);

        Button btnMainBack = findViewById(R.id.btnMainBack);
        TextView Display1 = findViewById(R.id.DisPlay1);
        TextView Display2 = findViewById(R.id.DisPlay2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String age = intent.getStringExtra("Age");
        String phone = intent.getStringExtra("Phone");

        Display1.setText("데이터 : "+name+"//"+age+"//"+phone);

        Student student = (Student)intent.getSerializableExtra("student");
        if(student!=null){
            Display2.setText("학생객체 : " + student.getSno() + "||" + student.getName() + "||" + student.getMajor());
        }

        btnMainBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

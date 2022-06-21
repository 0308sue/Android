package com.example.myapp08_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4_student extends AppCompatActivity {

    EditText editName,editSnum,editMajor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_student);

        editName = findViewById(R.id.editName);
        editSnum = findViewById(R.id.editSnum);
        editMajor = findViewById(R.id.editSub);
        Button button = findViewById(R.id.btnStuHome);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student();
                student.setSno(Integer.parseInt(editSnum.getText().toString()));
                student.setName(editName.getText().toString());
                student.setMajor(editMajor.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("student",student);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
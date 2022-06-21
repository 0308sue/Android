package com.example.myapp08_intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {

    String Name = null;
    String Age = null;
    String Phone = null;

    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button btnInput = findViewById(R.id.btnInput);
        Button btnOutput = findViewById(R.id.btnOutput);
        Button btnStudent = findViewById(R.id.btnStudent);


        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK){
                            Intent intent = result.getData();
                            student = (Student) intent.getSerializableExtra("student");


                            Name = intent.getStringExtra("Name");
                            Age = intent.getStringExtra("Age");
                            Phone = intent.getStringExtra("Phone");
                        }
                    }
                });

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity4_input.class);
                launcher.launch(intent);
            }
        });
                btnOutput.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity4_output.class);
                        intent.putExtra("Name", Name);
                        intent.putExtra("Age", Age);
                        intent.putExtra("Phone", Phone);

                        intent.putExtra("student",student);
                        startActivity(intent);
                    }
                });

                btnStudent.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity4_student.class);
                        launcher.launch(intent);
                    }
                });
    }
}
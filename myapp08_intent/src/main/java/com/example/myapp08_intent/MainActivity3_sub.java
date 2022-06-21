package com.example.myapp08_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3_sub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_sub);

        EditText Name = findViewById(R.id.etName);
        EditText Age = findViewById(R.id.etAge);
        Button btnEnd = findViewById(R.id.btnEnd);

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retIntent = new Intent(getApplicationContext(),MainActivity3.class);
                retIntent.putExtra("Name",Name.getText().toString());
                retIntent.putExtra("Age",Age.getText().toString());
                setResult(RESULT_OK,retIntent);
                finish();
            }
        });
    }
}
package com.example.myapp08_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4_input extends AppCompatActivity {

    Button btn1;
    EditText Name,Age,Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_input);

        btn1 = findViewById(R.id.btnWrite);
        Name = findViewById(R.id.editName);
        Age = findViewById(R.id.editAge);
        Phone = findViewById(R.id.editPhone);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retIntent = new Intent(getApplicationContext(),MainActivity4.class);
                retIntent.putExtra("Name",Name.getText().toString());
                retIntent.putExtra("Age",Age.getText().toString());
                retIntent.putExtra("Phone",Phone.getText().toString());
                setResult(RESULT_OK,retIntent);
                finish();
            }
        });
    }
}
package com.example.myapp032;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnletter,btnopen;
    EditText editText;
    RadioButton btnr,btnq;
    ImageView imgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        btnr = findViewById(R.id.btnr);
        btnq = findViewById(R.id.btnq);
        imgr = findViewById(R.id.imgr);
        btnletter = (Button) findViewById(R.id.btnletter);
        btnopen = (Button) findViewById(R.id.btnopen);

        btnletter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),editText.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),editText.getText().toString(),Toast.LENGTH_LONG).show();
                Intent intentletter = new Intent(Intent.ACTION_VIEW, Uri.parse(editText.getText().toString()));
                startActivity(intentletter);
            }
        });

        btnq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgr.setImageResource(R.drawable.q);
            }
        });

        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgr.setImageResource(R.drawable.r);
            }
        });

    }
}
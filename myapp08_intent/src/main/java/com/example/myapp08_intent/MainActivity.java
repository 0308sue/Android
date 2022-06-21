package com.example.myapp08_intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = findViewById(R.id.btnAdd);
        EditText edtNum1 = findViewById(R.id.edtNum1);
        EditText edtNum2 = findViewById(R.id.edtNum2);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == Activity.RESULT_OK){
                    Log.d("data : ",result.toString());
                    Intent intent = result.getData();
                    int hap = intent.getIntExtra("Result",0);
                    Toast.makeText(getApplicationContext(), "합계 :"+hap, Toast.LENGTH_SHORT).show();
                    Log.d("haphap : ",Integer.toString(hap));
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainActivity_sub.class);
                intent.putExtra("Num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(edtNum2.getText().toString()));

                // startActivity(intent);
                // startActivityForResult(intent,0);
                launcher.launch((intent));
            }
        });
    }

}
package com.example.myapp07;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3_return extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_return);

        Button btnAdd = findViewById(R.id.btnAdd);
        EditText edtNum1 = findViewById(R.id.edtNum1);
        EditText edtNum2 = findViewById(R.id.edtNum2);

        RadioGroup rg = findViewById(R.id.rg);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3_return.this,MainActivity3_return_sub.class);
                intent.putExtra("Num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(edtNum2.getText().toString()));
                intent.putExtra("cal",rg.getCheckedRadioButtonId());

               // startActivity(intent);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        TextView tvResult = findViewById(R.id.tvResult);
        if(resultCode==RESULT_OK){
            int Result = data.getIntExtra("Result",0);
            Toast.makeText(getApplicationContext(), "받아온 합계 :"+Result, Toast.LENGTH_SHORT).show();
            tvResult.setText(Integer.toString(Result));
        }
    }
}
package com.example.myapp04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    TextView TextResult;
    Button BtnSub,BtnMul,BtnDiv,BtnAdd;
    EditText Edit1,Edit2;
    String num1,num2;
    Double result;

    Button[] numButtons = new Button[10];
    Integer[] numBtnIds = {R.id.BtnNum0,R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,R.id.BtnNum5
            ,R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        TextResult = findViewById(R.id.TextResult);

        BtnMul = findViewById(R.id.BtnMul);
        BtnDiv = findViewById(R.id.BtnDiv);
        BtnAdd = findViewById(R.id.BtnAdd);
        BtnSub = findViewById(R.id.BtnSub);
        Edit1 = findViewById(R.id.Edit1);
        Edit2 = findViewById(R.id.Edit2);

        for (int i= 0;i<numButtons.length;i++){
            numButtons[i] = findViewById(numBtnIds[i]);
        }

        for (int i= 0;i<numButtons.length;i++){
            final int index;
            index = i;
            numButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Edit1.isFocused()==true){
                        num1 = Edit1.getText().toString()+numButtons[index].getText().toString();
                        Edit1.setText(num1);
                    }else if(Edit2.isFocused()==true){
                        num2 = Edit2.getText().toString()+numButtons[index].getText().toString();
                        Edit2.setText(num2);
                    }else{
                        Toast.makeText(getApplicationContext(),"먼저 에디터텍스트를 선택하세요",Toast.LENGTH_SHORT).show();;
                    }
                }
            });
        }



        BtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "입력 값이 비어있습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                result= Double.parseDouble(num1)+Double.parseDouble(num2);
                TextResult.setText(result.toString());
            }
        });

        BtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "입력 값이 비어있습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                result= Double.parseDouble(num1)-Double.parseDouble(num2);
                TextResult.setText(result.toString());
            }
        });

        BtnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "입력 값이 비어있습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                result= Double.parseDouble(num1)*Double.parseDouble(num2);
                TextResult.setText(result.toString());
            }
        });

        BtnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(num1.trim().equals("")||num2.trim().equals("")){
                    Toast.makeText(getApplicationContext(),
                            "입력 값이 비어있습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                result= Double.parseDouble(num1)/Double.parseDouble(num2);
                TextResult.setText(result.toString());
            }
        });




    }
}
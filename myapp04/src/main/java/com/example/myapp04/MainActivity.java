package com.example.myapp04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkAgree;
    TextView Text2;
    RadioGroup Rgroup1;
    RadioButton RdoCat,RdoRabbit,RdoDog;
    Button BtnOK;
    ImageView ImgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkAgree = findViewById(R.id.chkAgree);
        Text2 = findViewById(R.id.Text2);
        Rgroup1 = findViewById(R.id.Rgroup1);
        RdoCat = findViewById(R.id.RdoCat);
        RdoRabbit = findViewById(R.id.RdoRabbit);
        RdoDog = findViewById(R.id.RdoDog);
        BtnOK = findViewById(R.id.BtnOK);
        ImgPet = findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(chkAgree.isChecked()==true){
                    Text2.setVisibility(View.VISIBLE);
                    Rgroup1.setVisibility(View.VISIBLE);
                    BtnOK.setVisibility(View.VISIBLE);
                    ImgPet.setVisibility(View.VISIBLE);
                }else{
                    Text2.setVisibility(View.INVISIBLE);
                    Rgroup1.setVisibility(View.INVISIBLE);
                    BtnOK.setVisibility(View.INVISIBLE);
                    ImgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        BtnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (Rgroup1.getCheckedRadioButtonId()){
                    case R.id.RdoCat:
                        ImgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RdoRabbit:
                        ImgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.RdoDog:
                        ImgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"동물을 선택하세요",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
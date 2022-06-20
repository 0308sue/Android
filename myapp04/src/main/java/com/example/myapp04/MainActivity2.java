package com.example.myapp04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Switch switchAgree;
    TextView Text2;
    RadioGroup Rgroup1;
    RadioButton RdoCat,RdoRabbit,RdoDog;
    ImageView ImgPet;
    Button end,reset;

    RadioButton[] radioArray = new RadioButton[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        switchAgree = findViewById(R.id.switchAgree);
        Text2 = findViewById(R.id.Text2);
        Rgroup1 = findViewById(R.id.Rgroup1);
        RdoCat = findViewById(R.id.RdoCat);
        RdoRabbit = findViewById(R.id.RdoRabbit);
        RdoDog = findViewById(R.id.RdoDog);
        ImgPet = findViewById(R.id.ImgPet);
        end = findViewById(R.id.end);
        reset = findViewById(R.id.reset);

        radioArray[0] = findViewById(R.id.RdoCat);
        radioArray[1] = findViewById(R.id.RdoRabbit);
        radioArray[2] = findViewById(R.id.RdoDog);

        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switchAgree.isChecked()==true){
                    Text2.setVisibility(View.VISIBLE);
                    Rgroup1.setVisibility(View.VISIBLE);
                    ImgPet.setVisibility(View.VISIBLE);
                    end.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.VISIBLE);

                }else{
                    Text2.setVisibility(View.INVISIBLE);
                    Rgroup1.setVisibility(View.INVISIBLE);
                    ImgPet.setVisibility(View.INVISIBLE);
                    end.setVisibility(View.INVISIBLE);
                    reset.setVisibility(View.INVISIBLE);
                }
            }
        });

//        Rgroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                switch (Rgroup1.getCheckedRadioButtonId()){
//                    case R.id.RdoCat:
//                        ImgPet.setImageResource(R.drawable.cat);
//                        break;
//                    case R.id.RdoRabbit:
//                        ImgPet.setImageResource(R.drawable.dog);
//                        break;
//                    case R.id.RdoDog:
//                        ImgPet.setImageResource(R.drawable.rabbit);
//                        break;
//                }
//            }
//        });

//        RdoCat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ImgPet.setImageResource(R.drawable.cat);
//            }
//        });
//
//        RdoRabbit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ImgPet.setImageResource(R.drawable.rabbit);
//            }
//        });
//
//        RdoDog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ImgPet.setImageResource(R.drawable.dog);
//            }
//        });

        final int draw[] = {R.drawable.cat,R.drawable.rabbit,R.drawable.dog};

        for(int i=0; i < radioArray.length;i++){
            final int index;
            index = i;
            radioArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImgPet.setImageResource(draw[index] );
                }
            });
        }

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Rgroup1.setVisibility(View.INVISIBLE);
                Rgroup1.clearCheck();
                ImgPet.setVisibility(View.INVISIBLE);
                ImgPet.setImageResource(0);
                end.setVisibility(View.INVISIBLE);
                reset.setVisibility(View.INVISIBLE);
                switchAgree.setChecked(false);
            }
        });

    }
}
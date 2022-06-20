package com.example.myapp05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity4 extends AppCompatActivity {

    //RadioButton peach,mango,apple,orange;
    Button show;
    RadioGroup kind;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

//        peach=findViewById(R.id.peach);
//        mango=findViewById(R.id.mango);
//        apple=findViewById(R.id.apple);
//        orange=findViewById(R.id.orange);

        show=findViewById(R.id.show);

        kind = findViewById(R.id.kind);

        RadioButton radioButton = findViewById(kind.getCheckedRadioButtonId());

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = View.inflate(MainActivity4.this,R.layout.dialog2,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity4.this);
                img = dialogView.findViewById(R.id.img);
//                if (radioButton.toString()=="peach"){
//                dlg.setTitle("복숭아");
//                dlg.setView(dialogView);
//                img.setImageResource(R.drawable.peach);
//                dlg.setPositiveButton("닫기",null);
//                }
            }
        });
    }
}
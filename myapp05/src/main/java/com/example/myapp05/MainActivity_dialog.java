package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity_dialog extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dialog);

        button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity_dialog.this);
//                dlg.setTitle("제목입니다.");
//                dlg.setMessage("이곳이 내용");
//                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity_dialog.this,"확인 클릭",Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity_dialog.this,"취소 클릭",Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dlg.show();

//                new AlertDialog.Builder(MainActivity_dialog.this)
//                        .setTitle("제목입니다")
//                        .setMessage("이곳이 내용")
//                        .show();

                String[] versionArray = {"파이","큐(10)","알(11)"};
                boolean[] checkArray = new boolean[] {true,false,false};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity_dialog.this);
                dlg.setTitle("좋아하는 버전은?");
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        button.setText(versionArray[i]);
                    }
                });
                dlg.setPositiveButton("닫기",null);
                dlg.show();
            }
        });
    }
}
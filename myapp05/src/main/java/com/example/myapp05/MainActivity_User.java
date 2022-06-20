package com.example.myapp05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_User extends AppCompatActivity {
    Button button;
    TextView Name,Email,toastText1;
    EditText editname,editemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);

        button = findViewById(R.id.button1);

        Name = findViewById(R.id.tvName);
        Email = findViewById(R.id.tvEmail);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = View.inflate(MainActivity_User.this,R.layout.dialog1,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity_User.this );
                dlg.setTitle("사용자 정보 입력");
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        editname = dialogView.findViewById(R.id.dlgEdt1);
                        editemail = dialogView.findViewById(R.id.dlgEdt2);

                        Name.setText(editname.getText().toString());
                        Email.setText(editemail.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(MainActivity_User.this);
                        View toastView = view.inflate(MainActivity_User.this,R.layout.toast1,null);

                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset = (int)(Math.random() * display.getWidth());
                        int yOffset = (int)(Math.random() * display.getHeight());
                        toast.setGravity(Gravity.TOP|Gravity.LEFT,xOffset,yOffset);

                        toastText1 = toastView.findViewById(R.id.toastText1);
                        toastText1.setText("취소했습니다.");
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });

    }
}
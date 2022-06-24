package com.example.myapp09_adapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity3_gridMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_grid_main);

        GridView gridView1 = findViewById(R.id.gridView1);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gridView1.setAdapter(gridAdapter);

    }
        public class MyGridAdapter extends BaseAdapter{
        Context context;

            public MyGridAdapter(Context context){
               this.context = context;
            }
            @Override
            public int getCount() {
                return posterID.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView = new ImageView(context);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(200,300));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(5,5,5,5);

                imageView.setImageResource(posterID[i]);

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        View dialogView = View.inflate(MainActivity3_gridMain.this,R.layout.dialog,null);
                        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity3_gridMain.this);
                        ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);
                        ivPoster.setImageResource(posterID[i]);
                        dlg.setTitle("큰 포스터");
                        dlg.setIcon(R.drawable.ic_launcher);
                        dlg.setView(dialogView);
                        dlg.setNegativeButton("닫기",null);
                        dlg.show();
                    }
                });
                return imageView;
            }

            Integer[] posterID = {
            R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,
                    R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10,
            };
        }
}

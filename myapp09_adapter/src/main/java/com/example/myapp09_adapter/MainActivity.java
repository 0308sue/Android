package com.example.myapp09_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView1 = findViewById(R.id.listView1);
        String[] mid = {"리스트뷰 String 1","리스트뷰 String 2","리스트뷰 String 3","리스트뷰 String 4","리스트뷰 String 5",
                "리스트뷰 String 6","리스트뷰 String 7","리스트뷰 String 8","리스트뷰 String 9","리스트뷰 String 10"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,mid);

        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView1.setAdapter(arrayAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), mid[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
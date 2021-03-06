package com.example.myapp09_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2_ListMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_list_main);

        EditText edtItem = findViewById(R.id.editItem);
        Button btnAdd = findViewById(R.id.btnAdd);
        ListView listView = findViewById(R.id.listView1);

        ArrayList<String> arr = new ArrayList<>();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(arrayAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arr.add(edtItem.getText().toString());
                arrayAdapter.notifyDataSetChanged();
                edtItem.setText("");
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arr.remove(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
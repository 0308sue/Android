package com.example.myapp09_adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity5_personRecy extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5_person_recy);

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        PersonAdapter adapter = new PersonAdapter();
        recyclerView.setAdapter(adapter);


        for(int i = 0;i<10;i++){
            adapter.addItem(new personItem(i+"번",i+"번째","010-1111-1111",i));
        }
        adapter.setListener(new PersonListener() {
            @Override
            public void onItemClick(int position) {
                personItem personItem = adapter.getItem(position);
                Toast.makeText(MainActivity5_personRecy.this,personItem.getName()+" 선택됨",Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnLongItemClickListner(new PersonAdapter.OnLongItemClickListner() {
            @Override
            public void OnLongItemClick(int pos) {
                personItem personItem = adapter.getItem(pos);
                adapter.removeItem(pos);
            }
        });
    }
}
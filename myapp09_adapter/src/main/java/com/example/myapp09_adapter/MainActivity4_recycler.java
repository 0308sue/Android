package com.example.myapp09_adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity4_recycler extends AppCompatActivity {
    private RecyclerView mrecyclerView;
    private MyRecyclerAdapter myRecyclerAdapter;
    private ArrayList<FriendItem> mfriendItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_recycler);

        myRecyclerAdapter = new MyRecyclerAdapter();
        mrecyclerView = findViewById(R.id.recyclerView);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myRecyclerAdapter.setOnItemClickListner(new MyRecyclerAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(int pos) {
                Toast.makeText(getApplicationContext(), "OnItemClickListener pos :"+ pos, Toast.LENGTH_SHORT).show();
            }
        });

        myRecyclerAdapter.setOnLongItemClickListner(new MyRecyclerAdapter.OnLongItemClickListner() {
            @Override
            public void onLongItemClick(int pos) {
                Toast.makeText(getApplicationContext(), "OnLongItemClickListener pos :"+ pos, Toast.LENGTH_SHORT).show();
                myRecyclerAdapter.removeItem(pos);
            }
        });



        mfriendItems = new ArrayList<>();
        for(int i=0; i<10; i++){
            mfriendItems.add(new FriendItem(i+"번째 사람",i+"번째 메세지",R.drawable.ic_launcher));
        }
        mrecyclerView.setAdapter(myRecyclerAdapter);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myRecyclerAdapter.setFriendList(mfriendItems);
    }
}
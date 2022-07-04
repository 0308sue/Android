package com.example.myapp15_retrofit_phone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnadd,btnlist;
    EditText edName,edPhone;
    RecyclerView recyclerView;
    PhoneAdapter phoneAdapter;

    private PhoneService phoneService;


    List<Phone> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnadd = findViewById(R.id.btnadd);
        edName = findViewById(R.id.edName);
        edPhone = findViewById(R.id.edPhone);

        btnlist = findViewById(R.id.btnlist);

        FloatingActionButton floatBtn = findViewById(R.id.floatBtn);

        recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        phoneService = PhoneClient.getClient().create(PhoneService.class);
        Call<List<Phone>> call = phoneService.findAll();
        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                phoneAdapter = new PhoneAdapter(response.body());
                recyclerView.setAdapter(phoneAdapter);
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {

            }
        });

        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_concat,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("등록");
                dlg.setView(dialogView);
                dlg.setPositiveButton("등록", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final EditText etName = dialogView.findViewById(R.id.edtname);
                        final EditText ettel = dialogView.findViewById(R.id.edttel);
                        phoneService = PhoneClient.getClient().create(PhoneService.class);
                        Phone phone = new Phone(etName.getText().toString(),ettel.getText().toString());
                        Call<Phone> call =  phoneService.save(phone);
                        call.enqueue(new Callback<Phone>() {
                            @Override
                            public void onResponse(Call<Phone> call, Response<Phone> response) {
                                phoneAdapter.addItem(response.body());
                            }

                            @Override
                            public void onFailure(Call<Phone> call, Throwable t) {

                            }
                        });
                    }
                });
                dlg.setNegativeButton("닫기",null);
                dlg.show();
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Phone phone = new Phone(edName.getText().toString(),edPhone.getText().toString());
                phoneService = PhoneClient.getClient().create(PhoneService.class);
                Call<Phone> call =  phoneService.save(phone);
                call.enqueue(new Callback<Phone>() {
                    @Override
                    public void onResponse(Call<Phone> call, Response<Phone> response) {
                        phoneAdapter.addItem(response.body());
                    }

                    @Override
                    public void onFailure(Call<Phone> call, Throwable t) {

                    }
                });
            }
        });

//        btnlist.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                phoneService = PhoneClient.getClient().create(PhoneService.class);
//                Call<List<Phone>> call = phoneService.findAll();
//                call.enqueue(new Callback<List<Phone>>() {
//                    @Override
//                    public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
////                        for(Phone phone : response.body()){
////                            list.add(phone);
////                        }
////                        phoneAdapter.notifyDataSetChanged();
//
//                        phoneAdapter = new PhoneAdapter(response.body());
//                        recyclerView.setAdapter(phoneAdapter);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<Phone>> call, Throwable t) {
//
//                    }
//                });
//            }
//        });
    }
}
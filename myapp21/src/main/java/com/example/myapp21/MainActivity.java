package com.example.myapp21;

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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnadd,btnUpdate,btnDelete;
    EditText edName,edPhone;
    RecyclerView recyclerView;
    PhoneAdapter phoneAdapter;

    private com.example.myapp21.PhoneService phoneService;


    Phone phone;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnadd = findViewById(R.id.btnadd);
        edName = findViewById(R.id.edName);
        edPhone = findViewById(R.id.edPhone);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);


        recyclerView = findViewById(R.id.recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);



        phoneAdapter = new PhoneAdapter();
        recyclerView.setAdapter(phoneAdapter);

        phoneAdapter.setOnItmeClickListener(new PhoneAdapter.onItmeClickListener() {
            @Override
            public void onItemClick(int pos) {
                phone = phoneAdapter.getItem(pos);
                position = pos;
                edName.setText(phone.getName());
                edPhone.setText(phone.getTel());
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
            }

        });

        phoneService = PhoneClient.getClient().create(PhoneService.class);
        Call<List<Phone>> call = phoneService.findAll();

        call.enqueue(new Callback<List<Phone>>() {
            @Override
            public void onResponse(Call<List<Phone>> call, Response<List<Phone>> response) {
                List<Phone> phoneList = response.body();
                phoneAdapter.setAddList(phoneList);
            }

            @Override
            public void onFailure(Call<List<Phone>> call, Throwable t) {

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

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneService =  PhoneClient.getClient().create(PhoneService.class);
                Call<Void> call = phoneService.deleteById(phone.getId());
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        phoneAdapter.removeItem(position);

                        edName.setText("");
                        edPhone.setText("");

                        btnUpdate.setEnabled(false);
                        btnDelete.setEnabled(false);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                    }
                });

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Phone phonedto = new Phone(edName.getText().toString(),edPhone.getText().toString());
                phoneService = PhoneClient.getClient().create(PhoneService.class);
                Call<Phone> call = phoneService.update(phone.getId(), phonedto);
                call.enqueue(new Callback<Phone>() {
                    @Override
                    public void onResponse(Call<Phone> call, Response<Phone> response) {
                        phoneAdapter.updateItem(response.body(),position);

                        edName.setText("");
                        edPhone.setText("");

                        btnUpdate.setEnabled(false);
                        btnDelete.setEnabled(false);
                    }

                    @Override
                    public void onFailure(Call<Phone> call, Throwable t) {

                    }
                });
            }
        });

    }
}
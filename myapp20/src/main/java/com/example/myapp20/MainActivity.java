package com.example.myapp20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnRegister,btnUpdate,btnDelete;
    EditText edName,edAge,edPhone,edAddress,edEmail;
    RecyclerView memberRecyclerView;
    MemberAdapter memberAdapter;

    private MemberService memberService;

    Member member;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Member");

        memberRecyclerView = findViewById(R.id.memberRecyclerView);

        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        edPhone = findViewById(R.id.edPhone);
        edAddress = findViewById(R.id.edAddress);
        edEmail = findViewById(R.id.edEmail);

        btnRegister = findViewById(R.id.btnRegister);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);


        LinearLayoutManager linearLayoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        memberRecyclerView.setLayoutManager(linearLayoutManager);

        memberAdapter = new MemberAdapter();
        memberRecyclerView.setAdapter(memberAdapter);

        memberAdapter.setOnItemClickListener(new MemberAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                member = memberAdapter.getItem(pos);
                position = pos;
                edName.setText(member.getName());
                edAge.setText(member.getAge()+"");
                edPhone.setText(member.getPhone());
                edAddress.setText(member.getAddress());
                edEmail.setText(member.getEmail());

                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);

            }
        });

        //회원리스트 불러오기
        memberService = MemberClient.getInstance().getPhoneService();
        Call<List<Member>> call = memberService.list();
        call.enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                memberAdapter.setAddList(response.body());
                memberRecyclerView.setAdapter(memberAdapter);
            }

            @Override
            public void onFailure(Call<List<Member>> call, Throwable t) {

            }
        });


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member memberadd = new Member(edName.getText().toString(),
                        Integer.parseInt(edAge.getText().toString()),
                        edPhone.getText().toString(),
                        edAddress.getText().toString(),
                        edEmail.getText().toString());
                Call<Member> call = memberService.save(memberadd);
                call.enqueue(new Callback<Member>() {
                    @Override
                    public void onResponse(Call<Member> call, Response<Member> response) {
                        memberAdapter.addItem(response.body());

                        edName.setText("");
                        edAge.setText("");
                        edPhone.setText("");
                        edAddress.setText("");
                        edEmail.setText("");
                    }

                    @Override
                    public void onFailure(Call<Member> call, Throwable t) {

                    }
                });
            }
        });



        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Void> call = memberService.delete(member.getNum());
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        memberAdapter.deleteItem(position);

                        edName.setText("");
                        edAge.setText("");
                        edPhone.setText("");
                        edAddress.setText("");
                        edEmail.setText("");

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
                Member memberdto = new Member(edName.getText().toString(),
                        Integer.parseInt(edAge.getText().toString()),
                        edPhone.getText().toString(),
                        edAddress.getText().toString(),
                        edEmail.getText().toString());
                Call<Member> call = memberService.update(member.getNum(),memberdto);
                call.enqueue(new Callback<Member>() {
                    @Override
                    public void onResponse(Call<Member> call, Response<Member> response) {
                        memberAdapter.updateItem(response.body(), position);

                        edName.setText("");
                        edAge.setText("");
                        edPhone.setText("");
                        edAddress.setText("");
                        edEmail.setText("");

                        btnUpdate.setEnabled(false);
                        btnDelete.setEnabled(false);
                    }

                    @Override
                    public void onFailure(Call<Member> call, Throwable t) {

                    }
                });
            }
        });
    }
}
package com.example.myapp15_retrofit_phone;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder> {

    private List<Phone> phoneList;

    public PhoneAdapter(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void addItem(Phone phone){
        phoneList.add(phone);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        phoneList.remove(position);
        notifyDataSetChanged();
    }

    public void updateItem(Phone phone,int position){
        Phone p = phoneList.get(position);
        p.setName(phone.getName());
        p.setTel(phone.getTel());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_list,parent,false);
        PhoneViewHolder phoneViewHolder = new PhoneViewHolder(view);

        return phoneViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {
        Phone phone = phoneList.get(position);
        holder.tvName.setText(phone.getName());
        holder.tvTel.setText(phone.getTel());
        holder.tvId.setText(Long.toString(phone.getId()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = view.inflate(view.getContext(),R.layout.layout_concat,null);
                EditText etname = dialogView.findViewById(R.id.edtname);
                EditText ettel = dialogView.findViewById(R.id.edttel);

                etname.setText(phone.getName());
                ettel.setText(phone.getTel());

                AlertDialog.Builder dlg = new AlertDialog.Builder(view.getContext());
                dlg.setTitle("수정");
                dlg.setView(dialogView);
                dlg.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Phone phonedto = new Phone(etname.getText().toString(),ettel.getText().toString());
                        PhoneService phoneService = PhoneClient.getClient().create(PhoneService.class);
                        Call<Phone> call= phoneService.update(phone.getId(),phonedto);
                        call.enqueue(new Callback<Phone>() {
                            @Override
                            public void onResponse(Call<Phone> call, Response<Phone> response) {
                                updateItem(response.body(),position);
                            }

                            @Override
                            public void onFailure(Call<Phone> call, Throwable t) {

                            }
                        });
                    }
                });
                dlg.setNegativeButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PhoneService phoneService = PhoneClient.getClient().create(PhoneService.class);
                        Call<Void> call= phoneService.deleteById(phone.getId());
                        call.enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                removeItem(position);
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {

                            }
                        });
                    }
                });
                dlg.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return phoneList ==  null ? 0 : phoneList.size();
    }

    class PhoneViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvTel,tvId;
        View itemView;

        public PhoneViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.tvName = itemView.findViewById(R.id.txName);
            this.tvTel = itemView.findViewById(R.id.txTel);
            this.tvId = itemView.findViewById(R.id.txId);
        }
    }
}

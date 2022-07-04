package com.example.myapp21;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

    public interface  onItmeClickListener{
        void onItemClick(int pos);
    }
    private onItmeClickListener onItmeClickListener;

    public  void setOnItmeClickListener(onItmeClickListener onItmeClickListener){
        this.onItmeClickListener = onItmeClickListener;
    }

    public PhoneAdapter(){

    }

    public PhoneAdapter(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public void setAddList(List<Phone> phoneList){
        this.phoneList = phoneList;
        notifyDataSetChanged();
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

    public Phone getItem(int position){
        Phone phone = phoneList.get(position);
        return phone;
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.phone_list,parent,false);
        PhoneViewHolder phoneViewHolder = new PhoneViewHolder(view,onItmeClickListener);

        return phoneViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {
        Phone phone = phoneList.get(position);
        holder.tvName.setText(phone.getName());
        holder.tvTel.setText(phone.getTel());
        holder.tvId.setText(Long.toString(phone.getId()));

    }

    @Override
    public int getItemCount() {
        return phoneList ==  null ? 0 : phoneList.size();
    }



    class PhoneViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvTel,tvId;
        View itemView;
        public PhoneViewHolder(@NonNull View itemView,onItmeClickListener onItmeClickListener){
            super(itemView);
            this.tvName = itemView.findViewById(R.id.txName);
            this.tvTel = itemView.findViewById(R.id.txTel);
            this.tvId = itemView.findViewById(R.id.txId);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    onItmeClickListener.onItemClick(position);
                }
            });

        }


    }
}

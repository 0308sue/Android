package com.example.myapp09_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    public  interface OnLongItemClickListner{
        void OnLongItemClick(int pos);
    }
    private OnLongItemClickListner onLongItemClickListner;

    public void setOnLongItemClickListner(OnLongItemClickListner onLongItemClickListner) {
        this.onLongItemClickListner = onLongItemClickListner;
    }

    private ArrayList<personItem> peronList = new ArrayList<>();

    private PersonListener listener;
    public void setListener(PersonListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item,parent,false);
        return new ViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {

        personItem personItem = peronList.get(position);
        holder.name.setText(personItem.getName());
        holder.message.setText(personItem.getMessage());
        holder.phone.setText(personItem.getPhone());
        holder.num.setText(personItem.getResourceId()+"");
    }

    @Override
    public int getItemCount() {
        return peronList.size();
    }


    public void addItem(personItem personItem){
        peronList.add(personItem);
    }

    public personItem getItem(int position){
        personItem personItem = peronList.get(position);
        return personItem;
    }

    public void removeItem(int position){
        peronList.remove(position);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView message;
        TextView phone;
        TextView num;

        public ViewHolder(@NonNull View itemView,final PersonListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            message = itemView.findViewById(R.id.message);
            phone = itemView.findViewById(R.id.phone);
            num = itemView.findViewById(R.id.num);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    listener.onItemClick(position);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = getAdapterPosition();
                    onLongItemClickListner.OnLongItemClick(position);
                    return true;
                }
            });
        }
    }
}

package com.example.myapp09_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHorder> {

    public interface OnItemClickListner{
        void onItemClick(int pos);
    }
    public interface OnLongItemClickListner{
        void onLongItemClick(int pos);
    }
    private OnItemClickListner onItemClickListner;
    private OnLongItemClickListner onLongItemClickListner;

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public void setOnLongItemClickListner(OnLongItemClickListner onLongItemClickListner) {
        this.onLongItemClickListner = onLongItemClickListner;
    }

    ArrayList<FriendItem> mFriendList;

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHorder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyclerview,parent,false);

        return new ViewHorder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHorder holder, int position) {

        FriendItem friendItem = mFriendList.get(position);
        holder.profile.setImageResource(friendItem.getResourceId());
        holder.name.setText(friendItem.getName());
        holder.message.setText(friendItem.getMessage());
    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }

    public void setFriendList(ArrayList<FriendItem> mfriendItems ){
        mFriendList = mfriendItems;
        notifyDataSetChanged();
    }

    public void removeItem (int pos){
        mFriendList.remove(pos);
        notifyDataSetChanged();
    }

    class ViewHorder extends RecyclerView.ViewHolder{
        ImageView profile;
        TextView name;
        TextView message;

        public ViewHorder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.profile);
            name = itemView.findViewById(R.id.name);
            message = itemView.findViewById(R.id.message);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    onItemClickListner.onItemClick(position);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = getAdapterPosition();
                    onLongItemClickListner.onLongItemClick(position);
                    return true;
                }
            });
        }
    }
}

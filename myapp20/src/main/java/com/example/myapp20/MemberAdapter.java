package com.example.myapp20;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {

    List<Member> memberList;

    public interface OnItemClickListener{
        void onItemClick(int pos);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public MemberAdapter(){

    }

    public MemberAdapter(List<Member> memberList) {
        this.memberList = memberList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view,onItemClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Member member = memberList.get(position);

        holder.tvName.setText(member.getName());
        holder.tvAge.setText(Integer.toString(member.getAge()));
        holder.tvPhone.setText(member.getPhone());
        holder.tvAddress.setText(member.getAddress());
        holder.tvEmail.setText(member.getEmail());
    }

    @Override
    public int getItemCount() {
        return memberList==null?0:memberList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvAge, tvPhone, tvAddress, tvEmail;

        public ViewHolder(@NonNull View itemView,OnItemClickListener onItemClickListener) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.tvName);
            this.tvAge = itemView.findViewById(R.id.tvAge);
            this.tvPhone = itemView.findViewById(R.id.tvPhone);
            this.tvAddress = itemView.findViewById(R.id.tvAddress);
            this.tvEmail = itemView.findViewById(R.id.tvEmail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    onItemClickListener.onItemClick(position);
                }
            });
        }

    }

    //추가
    public void addItem(Member member){
        memberList.add(member);
        notifyDataSetChanged();
    }

    //수정
    public void updateItem(Member member, int position){
        Member m = memberList.get(position);
        m.setName(member.getName());
        m.setAge(member.getAge());
        m.setAddress(member.getAddress());
        m.setPhone(member.getPhone());
        m.setEmail(member.getEmail());
        notifyDataSetChanged();
    }

    //삭제
    public void deleteItem(int position){
        memberList.remove(position);
        notifyDataSetChanged();
    }

    public Member getItem(int position){
        Member member = memberList.get(position);
        return member;
    }

    public void setAddList(List<Member> memberList){
        this.memberList = memberList;
        notifyDataSetChanged();
    }
}

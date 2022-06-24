package com.example.myapp12_viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolderPage> {
    private ArrayList<DataPage> listData;

    ViewPagerAdapter(ArrayList<DataPage> data){
        listData = data;
    }


    @NonNull
    @Override
    public ViewHolderPage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_viewpager,parent,false);
        return new ViewHolderPage(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPage holder, int position) {
//        if(holder instanceof ViewHolderPage){
//            ViewHolderPage viewHolderPage = (ViewHolderPage) holder;
//            viewHolderPage.onBind(listData.get(position));
//        }
        holder.tv_title.setText(listData.get(position).getTitle());
        holder.rl_layout.setBackgroundColor(listData.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ViewHolderPage extends RecyclerView.ViewHolder{
        private TextView tv_title;
        private RelativeLayout rl_layout;

        DataPage data;

        public ViewHolderPage(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            rl_layout = itemView.findViewById(R.id.rl_layout);
        }

        public void onBind(DataPage data){
            this.data = data;
            tv_title.setText(data.getTitle());
            rl_layout.setBackgroundColor(data.getColor());
        }
    }
}

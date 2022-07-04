package com.example.myapp14_retofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> postList;

    public PostAdapter(List<Post> postList) {this.postList = postList;}

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        PostViewHolder postviewholder = new PostViewHolder(view);

        return postviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.imageView.setImageResource(R.drawable.mov07);
        holder.tvId.setText(Integer.toString(post.getId()));
        holder.txTitle.setText(post.getTitle());
        holder.txBody.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return postList == null ? 0: postList.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        TextView tvId,txTitle,txBody;
        ImageView imageView;
        View itemView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.tvId = itemView.findViewById(R.id.txId);
            this.txTitle =  itemView.findViewById(R.id.txTitle);
            this.txBody =  itemView.findViewById(R.id.txUrl);
            this.imageView =  itemView.findViewById(R.id.imageView);
        }
    }
}

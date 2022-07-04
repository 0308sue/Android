package com.example.myapp14_retofit;

import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList){
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.imageView.setImageResource(R.drawable.mov12);
        holder.tvId.setText(Integer.toString(movie.getId()));
        holder.txTitle.setText(movie.getTitle());
        holder.txUrl.setText(movie.getUrl());

       // notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tvId,txTitle,txUrl;
        ImageView imageView;
        View itemView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.tvId = itemView.findViewById(R.id.txId);
            this.txTitle =  itemView.findViewById(R.id.txTitle);
            this.txUrl =  itemView.findViewById(R.id.txUrl);
            this.imageView =  itemView.findViewById(R.id.imageView);
        }
    }
}

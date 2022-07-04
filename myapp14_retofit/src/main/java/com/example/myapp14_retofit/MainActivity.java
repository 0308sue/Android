package com.example.myapp14_retofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button,button2;
    MovieAdapter movieAdapter;
    private  MovieInterface apiInterface;
    private  MovieInterface apiInterface2;

    PostAdapter postAdapter;

    List<Movie> list;
    List<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerview);


        button2 = findViewById(R.id.button2);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list = new ArrayList<>();
                movieAdapter = new MovieAdapter(list);
                recyclerView.setAdapter(movieAdapter);
                apiInterface =    MovieClient.getClient().create(MovieInterface.class);
                Call<List<Movie>> call = apiInterface.doGetMovies();

                call.enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        Log.d(">>> code : ",response.code()+"");
                        Log.d(">>> response : ",response.body().size()+"");
                        List<Movie> resource = response.body();
                        Log.d(">>> resource size : ",resource.size()+"");
//                        for (Movie movie  : resource){
//                            list.add(movie);
//                        }
                        movieAdapter = new MovieAdapter(resource);
                        recyclerView.setAdapter(movieAdapter);
                        Log.d(">>> getItemCount : ",movieAdapter.getItemCount()+"");
//                        movieAdapter.notifyDataSetChanged();
                    }


                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {

                    }
                });
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posts = new ArrayList<>();
                postAdapter = new PostAdapter(posts);
                recyclerView.setAdapter(postAdapter);
                apiInterface2 =    MovieClient.getClient().create(MovieInterface.class);
                Call<List<Post>> call = apiInterface2.doGetPosts();
                call.enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                        for(Post post : response.body()){
                            posts.add(post);
                        }
                        postAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {

                    }
                });
            }
        });
    }
}
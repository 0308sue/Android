package com.example.myapp14_retofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieInterface {
    @GET("photos/")
    Call<List<Movie>> doGetMovies();

    @GET("posts/")
    Call<List<Post>> doGetPosts();
}

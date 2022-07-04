package com.example.myapp21;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhoneClient {
    private static Retrofit retrofit;

    static Retrofit getClient(){
        retrofit = new Retrofit.Builder().baseUrl("http://10.100.102.99:9988/").addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}

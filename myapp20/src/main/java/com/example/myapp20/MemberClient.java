package com.example.myapp20;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MemberClient {

    private static MemberClient instance;
    private MemberService memberService;

    public MemberClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.100.102.99:9988/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        memberService = retrofit.create(MemberService.class);
    }

    public static MemberClient getInstance() {
        if(instance == null) {
            instance = new MemberClient();
        }
        return instance;
    }

    public MemberService getPhoneService() {
        return memberService;
    }



}

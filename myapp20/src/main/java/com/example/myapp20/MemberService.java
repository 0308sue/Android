package com.example.myapp20;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MemberService {

    //전체보기
    @GET("member/list")
    Call<List<Member>> list();

    //추가
    @POST("member/insert")
    Call<Member> save(@Body Member member);

    //수정
    @PUT("member/update/{id}")
    Call<Member> update(@Path("id") Long id, @Body Member member);

    //삭제
    @DELETE("member/delete/{id}")
    Call<Void> delete(@Path("id") Long id);
}

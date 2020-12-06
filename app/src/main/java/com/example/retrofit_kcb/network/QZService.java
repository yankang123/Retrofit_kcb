package com.example.retrofit_kcb.network;

import com.example.retrofit_kcb.model.Token;
import com.example.retrofit_kcb.model.kb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface QZService {

    @GET("app.do?method=authUser")
    Call<Token> gettoken(@Query("xh") String xh, @Query("pwd") String pwd );
//    @Headers("token: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDcwOTA1ODAsImF1ZCI6IjE4NDA4MDAwOTM1In0.ttjWuhrZsXj2IX7U-atFlKk2kyrG7oDTUG-qvzDJyDk")
    @GET("app.do?method=getKbcxAzc")
    Call<List<kb>> getkb(@Query("xh") String xh, @Query("pwd") String pwd , @Query("zc") String zc, @Query("xnxqid") String xnxqid, @Header("token") String token);
}

package com.example.Popsonal.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import com.example.Popsonal.entity.Customers;

public interface ApiService {
    @POST("/api/register") // 서버의 회원가입 엔드포인트
    Call<Void> registerUser(@Body Customers user);
}
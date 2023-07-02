package com.example.bai1androidnetworking.Interface;


import com.example.bai1androidnetworking.Class.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Callapi {
    @GET("users")
    Call<List<User>> getApiData();

}

package com.example.bai1androidnetworking.Interface;


import com.example.bai1androidnetworking.Class.GirlFriend;
import com.example.bai1androidnetworking.Class.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Callapi {
//    @GET("/")
//    Call<List<GirlFriend>> getApiData();

    @GET("/users/")
    Call<List<User>> getAllUser();

//    @POST("/GFmanager/addGF")
//    Call<List<GirlFriend>> addGF(@Body GirlFriend girlFriend);
}

package com.example.bai1androidnetworking.Interface;


import com.example.bai1androidnetworking.Class.GirlFriend;
import com.example.bai1androidnetworking.Class.User;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface Callapi {
    //    @GET("/")
    //    Call<List<GirlFriend>> getApiData();
    @GET("/users")
    Call<List<User>> getAllUser();

    @DELETE("/users/delete/{id}")
    Call<User> DeleteUser(@Path("id") String id);

    @POST("/users/add")
    Call<User> CreateUser(@Body User user);


//    @POST("/GFmanager/addGF")
//    Call<List<GirlFriend>> addGF(@Body GirlFriend girlFriend);
}

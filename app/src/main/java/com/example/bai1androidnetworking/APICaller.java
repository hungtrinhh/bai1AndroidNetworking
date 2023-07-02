package com.example.bai1androidnetworking;

import java.net.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICaller {


    public static final String URL = "http://192.168.0.101:9000/";
    public static Retrofit retrofit;

    public static Retrofit GetRetrofitInstante() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;

    }


}

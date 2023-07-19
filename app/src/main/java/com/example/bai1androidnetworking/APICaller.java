package com.example.bai1androidnetworking;

import java.net.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICaller {


    public static final String URL = "http://26.241.100.175:9000/";
    private static Retrofit retrofit;

    public static Retrofit GetRetrofitInstante() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;

    }


}

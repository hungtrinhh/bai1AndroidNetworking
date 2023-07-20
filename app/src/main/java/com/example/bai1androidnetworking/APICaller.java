package com.example.bai1androidnetworking;

import android.util.Log;

import com.example.bai1androidnetworking.Class.User;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICaller {

    private static String ip ="192.168.50.199";



    private static Retrofit retrofit;
    private static String URL;
    private final static String TAG = "APICaller";

    public static Retrofit GetRetrofitInstante() {
        if (retrofit == null) {

            URL = "http://" + ip + ":3000/";
            Log.e(TAG, "GetRetrofitInstante: " + URL);
            retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;

    }



}

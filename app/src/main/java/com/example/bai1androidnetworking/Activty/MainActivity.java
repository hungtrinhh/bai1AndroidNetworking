package com.example.bai1androidnetworking.Activty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bai1androidnetworking.APICaller;
import com.example.bai1androidnetworking.Class.User;
import com.example.bai1androidnetworking.Interface.Callapi;
import com.example.bai1androidnetworking.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    String TAG = "mainactiviti";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Callapi apiCaller = APICaller.GetRetrofitInstante().create(Callapi.class);
        Call<List<User>> call = apiCaller.getApiData();
        lv = findViewById(R.id.lv);
        List<String> userString = new ArrayList<>();


        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d(TAG, "onResponse: " + response.body());

                if (response.isSuccessful()) {

                    String text = "";
                    List<User> list = response.body();
                    for (User u : list
                    ) {

                        userString.add(u.toString());
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_list_item_1, userString);
                    lv.setAdapter(adapter);

                    Log.e("MainActivity", "onResponse:  " + response.body());
                } else {
                    Log.e("MainActivity", "Response error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("MainActivity", "Request error: " + t.getMessage());

            }
        });
        Log.e(TAG, "onCreate: checkinternet" + Checkineret());


    }

    public boolean Checkineret() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
        return false;

    }
}
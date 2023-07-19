package com.example.bai1androidnetworking.Activty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.bai1androidnetworking.APICaller;
import com.example.bai1androidnetworking.Class.GirlFriend;
import com.example.bai1androidnetworking.Class.TypeGF;
import com.example.bai1androidnetworking.Class.User;
import com.example.bai1androidnetworking.Interface.Callapi;
import com.example.bai1androidnetworking.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    String TAG = "mainactiviti";
    private Callapi apiCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiCaller = APICaller.GetRetrofitInstante().create(Callapi.class);
        Call<List<User>> call = apiCaller.getAllUser();
        List<String> userString = new ArrayList<>();
        recyclerView = findViewById(R.id.lvActivityMain);

        Log.e(TAG, "onCreate: checkinternet : ".toUpperCase() + Checkineret());

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

                    Log.e("MainActivity", "onResponse:  " + response.body());
                } else {
                    Log.e("MainActivity", "Response error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + call);

            }
        });
    }

    public boolean Checkineret() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
        return false;

    }

//    void AddGirl() {
//
//        GirlFriend gf = new GirlFriend();
//        gf.name = "Hung trinh";
//        gf.phone = "123123123123";
//        gf.des = "Ngực tấn công mông phòng thử";
//        gf.typeGF = new TypeGF("xinh gai", "64b67ccc09386aedbaddc322");
//
//        Call<List<GirlFriend>> callAddGf = apiCaller.addGF(gf);
//        callAddGf.enqueue(new Callback<List<GirlFriend>>() {
//            @Override
//            public void onResponse(Call<List<GirlFriend>> call, Response<List<GirlFriend>> response) {
//
//                Log.e(TAG, "onResponse: " + call);
//            }
//
//            @Override
//            public void onFailure(Call<List<GirlFriend>> call, Throwable t) {
//                Log.e(TAG, "onFailure: " + call);
//            }
//        });
//
//
//    }
}
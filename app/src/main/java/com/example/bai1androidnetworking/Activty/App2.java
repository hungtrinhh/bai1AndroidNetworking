package com.example.bai1androidnetworking.Activty;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bai1androidnetworking.R;

public class App2 extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.app2);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

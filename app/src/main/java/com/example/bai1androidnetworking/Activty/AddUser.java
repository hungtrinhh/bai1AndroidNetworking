package com.example.bai1androidnetworking.Activty;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.bai1androidnetworking.APICaller;
import com.example.bai1androidnetworking.Adapter.adapterUser;
import com.example.bai1androidnetworking.Class.User;
import com.example.bai1androidnetworking.Interface.Callapi;
import com.example.bai1androidnetworking.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddUser extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "ADD USER";
    private EditText nameEditText;
    private EditText phoneEditText;
    private EditText ageEditText;
    private Button btnAdd;
    private Button btnCancel;

    private Callapi apiCaller;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app2);
        findID();

        apiCaller = APICaller.GetRetrofitInstante().create(Callapi.class);


    }

    void findID() {
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        phoneEditText = (EditText) findViewById(R.id.phoneEditText);
        ageEditText = (EditText) findViewById(R.id.ageEditText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnAdd.setOnClickListener(this::onClick);
        btnCancel.setOnClickListener(this::onClick);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v == btnAdd) {
            String name = nameEditText.getText().toString();
            String ageStr = ageEditText.getText().toString();
            String phone = phoneEditText.getText().toString();

            if (name.equalsIgnoreCase("") || ageStr.equalsIgnoreCase("") || phone.equalsIgnoreCase("")) {
                Toast.makeText(getApplicationContext(), "Không được để trông các trường dữ liệu", Toast.LENGTH_LONG).show();

            } else {
                if (ageStr.length() > 3) {
                    Toast.makeText(getApplicationContext(), "Tuổi của người không thể lớn hớn 999", Toast.LENGTH_LONG).show();

                } else {
                    int age = Integer.parseInt(ageStr);
                    User u = new User(name, age, phone);
                    Call<User> call = apiCaller.CreateUser(u);

                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Thêm thất bại", Toast.LENGTH_LONG).show();

                        }
                    });

                }


            }

        } else if (v == btnCancel) {
            onBackPressed();

        }


    }
}

package com.example.bai1androidnetworking.Class;

import androidx.annotation.NonNull;

public class User {
    public String name;
    public int age;
public  String status;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }
}

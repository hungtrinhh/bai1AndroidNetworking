package com.example.bai1androidnetworking.Class;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("_id")
    String id;
    @SerializedName("name")
    private String name;
    @SerializedName("age")
    private int age;
    @SerializedName("phone")
    private String phone;

    public User(String name, int age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getters and Setters (or use Lombok for automatic generation)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}

package com.example.bai1androidnetworking.Class;

public class GirlFriend {
    public String _id;
    public String phone;
    public String des;
    public TypeGF typeGF;

    @Override
    public String toString() {
        return "GirlFriend{" +
                "_id='" + _id + '\'' +
                ", phone='" + phone + '\'' +
                ", des='" + des + '\'' +
                ", type=" + typeGF +
                ", name='" + name + '\'' +
                '}';
    }

    public String name;

}


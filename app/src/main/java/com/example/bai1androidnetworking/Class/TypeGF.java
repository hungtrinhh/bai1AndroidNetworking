package com.example.bai1androidnetworking.Class;

public class TypeGF {
    public String name;
    public String _id;

    public TypeGF(String name, String _id) {
        this.name = name;
        this._id = _id;
    }

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + "'\n" +
                ", id='" + _id + "'\n" +
                '}';
    }
}
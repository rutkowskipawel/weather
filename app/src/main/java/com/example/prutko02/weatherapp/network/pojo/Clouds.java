package com.example.prutko02.weatherapp.network.pojo;

import com.google.gson.annotations.SerializedName;


public class Clouds {
    @SerializedName("all")
    private Integer all;

    @Override
    public String toString() {
        return "Clouds{" + "all=" + all + '}';
    }
}

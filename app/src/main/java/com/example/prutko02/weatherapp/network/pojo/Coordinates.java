package com.example.prutko02.weatherapp.network.pojo;

import com.google.gson.annotations.SerializedName;

public class Coordinates {
    @SerializedName("lon")
    private Double longitude;
    @SerializedName("lat")
    private Double latitude;

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }


    @Override
    public String toString() {
        return "Coordinates{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}

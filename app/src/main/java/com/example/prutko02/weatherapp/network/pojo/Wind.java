package com.example.prutko02.weatherapp.network.pojo;

import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("speed")
    private Double speed;
    @SerializedName("deg")
    private Integer deg;

    public Double getSpeed() {
        return speed;
    }

    public Integer getDeg() {
        return deg;
    }

    @Override
    public String toString() {
        return "Wind{" + "speed=" + speed +
                ", deg=" + deg +
                '}';
    }
}

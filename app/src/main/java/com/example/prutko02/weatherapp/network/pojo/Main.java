package com.example.prutko02.weatherapp.network.pojo;

import com.google.gson.annotations.SerializedName;

public class Main {
    /** Temperature. Unit Default: Kelvin, Metric: Celsius, Imperial: Fahrenheit. **/
    @SerializedName("tempretature")
    private Double tempretature;
    @SerializedName("pressure")
    private Integer pressure;
    @SerializedName("humidity")
    private Integer humidity;
    @SerializedName("temp_min")
    private Double tempMin;
    @SerializedName("temp_max")
    private Double tempMax;

    public Double getTempretature() {
        return tempretature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    @Override
    public String toString() {
        return "Main{" + "tempretature=" + tempretature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                '}';
    }
}

package com.example.prutko02.weatherapp.network.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapping JSON with weatherDescription to POJO
 */
public class WeatherResponse {
    @SerializedName("coord")
    private Coordinates coordinates;
    @SerializedName("weather")
    private List<WeatherDescription> weatherDescription = new ArrayList<>();
    //Internal parameter
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private Main main;
    @SerializedName("visibility")
    private Integer visibility;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("dt")
    private Integer dt;
    @SerializedName("sys")
    private Sys sys;
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String cityName;
    @SerializedName("cod")
    private Integer cod;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public List<WeatherDescription> getWeatherDescription() {
        return weatherDescription;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Integer getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public Integer getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public Integer getCod() {
        return cod;
    }


    @Override
    public String toString() {
        return "WeatherResponse{" +
                "coordinates=" + coordinates +
                ", weatherDescription=" + weatherDescription +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt=" + dt +
                ", sys=" + sys +
                ", id=" + id +
                ", cityName='" + cityName + '\'' +
                ", cod=" + cod +
                '}';
    }
}

package com.example.prutko02.weatherapp.network.pojo;

import com.google.gson.annotations.SerializedName;


public class Weather {
    @SerializedName("id")
    private Integer id;
    @SerializedName("mainWeatherCondition")
    private String mainWeatherCondition;
    @SerializedName("description")
    private String description;
    /** Weather icon id **/
    @SerializedName("icon")
    private String icon;

    public Integer getId() {
        return id;
    }

    /**
     *
     * @return Weather parameters (Rain, Snow, Extreme etc.)
     */
    public String getMainWeatherCondition() {
        return mainWeatherCondition;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return "Weather{" + "id=" + id +
                ", mainWeatherCondition='" + mainWeatherCondition + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}

package com.example.prutko02.weatherapp.network.pojo;

import com.google.gson.annotations.SerializedName;


public class WeatherDescription {
    @SerializedName("id")
    private Integer id;
    @SerializedName("mainWeatherCondition")
    private String mainWeatherCondition;
    @SerializedName("description")
    private String description;
    /** WeatherDescription icon id **/
    @SerializedName("icon")
    private String icon;

    public Integer getId() {
        return id;
    }

    /**
     *
     * @return WeatherDescription parameters (Rain, Snow, Extreme etc.)
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
        return "WeatherDescription{" + "id=" + id +
                ", mainWeatherCondition='" + mainWeatherCondition + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}

package com.example.prutko02.weatherapp.network.api;

import com.example.prutko02.weatherapp.AppContext;
import com.example.prutko02.weatherapp.BuildConfig;
import com.example.prutko02.weatherapp.network.pojo.WeatherResponse;

import io.reactivex.Observable;


public class WeatherApiProxy {

    public static Observable<WeatherResponse> getWeather(String city) {
        return getWeather(city, WeatherApi.METRIC, WeatherApi.English);
    }

    public static Observable<WeatherResponse> getWeather(String city, @WeatherApi.Units String units, @WeatherApi.Lang String lang) {
        final AppContext appContext = AppContext.getAppContext();
        final WeatherApi weatherApi = appContext.getWeatherApi();
        return weatherApi.getWeather(BuildConfig.OPEN_WEATHER_MAP_API_VERSION, city, units, lang, BuildConfig.OPEN_WEATHER_MAP_KEY);
    }
}

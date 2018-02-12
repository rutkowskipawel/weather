package com.example.prutko02.weatherapp.utils;

import android.util.Log;

import com.example.prutko02.weatherapp.model.Weather;
import com.example.prutko02.weatherapp.network.pojo.WeatherDescription;
import com.example.prutko02.weatherapp.network.pojo.WeatherResponse;

import java.util.List;
public class DataMapper {

    private static final String TAG = DataMapper.class.getSimpleName();

    public static  void transformWeatherResponseToWeather(WeatherResponse weatherResponse, Weather weather) {
        LogUtil.log(Log.VERBOSE, TAG, weatherResponse.toString());

        String description = "";
        List<WeatherDescription> weatherDescriptionList =  weatherResponse.getWeatherDescription();
        if(weatherDescriptionList.size()>0){
            description = weatherDescriptionList.get(0).getDescription();
        }

        weather.setCountryCode(weatherResponse.getSys().getCountry());
        weather.setDescription(description);
        weather.setPressure(weatherResponse.getMain().getPressure());
        weather.setHumidity(weatherResponse.getMain().getHumidity());
        weather.setTemperature(weatherResponse.getMain().getTemperature());
        weather.setLatitude(weatherResponse.getCoordinates().getLatitude());
        weather.setLongitude(weatherResponse.getCoordinates().getLongitude());
        weather.setTempMin(weatherResponse.getMain().getTempMin());
        weather.setTempMax(weatherResponse.getMain().getTempMax());
        weather.setTimestamp(weatherResponse.getDt());

    }
}

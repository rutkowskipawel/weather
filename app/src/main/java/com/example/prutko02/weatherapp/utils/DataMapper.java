package com.example.prutko02.weatherapp.utils;

import android.util.Log;

import com.example.prutko02.weatherapp.model.Weather;
import com.example.prutko02.weatherapp.network.pojo.WeatherDescription;
import com.example.prutko02.weatherapp.network.pojo.WeatherResponse;

import java.util.List;
public class DataMapper {

    private static final String TAG = DataMapper.class.getSimpleName();

    public static void transformWeatherResponseToWeather(WeatherResponse weatherResponse, Weather weather) {
        LogUtil.log(Log.VERBOSE, TAG, weatherResponse.toString());
        String description = "";
        List<WeatherDescription> weatherDescriptionList =  weatherResponse.getWeatherDescription();
        if(weatherDescriptionList.size()>0){
            description = weatherDescriptionList.get(0).getDescription();
        }

        weather.setCityName(weatherResponse.getCityName());
        weather.setCountryCode(weatherResponse.getSys().getCountry());
        weather.setDescription(description);
        weather.setPressure(weatherResponse.getMain().getPressure());
        weather.setHumidity(weatherResponse.getMain().getHumidity());
        final Double temperatureKelvin = weatherResponse.getMain().getTemperature();
        final Double temperatureCelcius =  DataMapper.transformToCelcius(temperatureKelvin);
        weather.setTemperature(temperatureCelcius);
        weather.setLatitude(weatherResponse.getCoordinates().getLatitude());
        weather.setLongitude(weatherResponse.getCoordinates().getLongitude());
        weather.setTimestamp(weatherResponse.getDt());
    }

    private static Double transformToCelcius(Double temperatureKelvin) {
        return Math.floor(temperatureKelvin - 273.15);
    }
}

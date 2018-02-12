package com.example.prutko02.weatherapp.network.api;

import com.example.prutko02.weatherapp.network.pojo.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface WeatherApi {

    @GET("/data/{apiVersion}/weather")
    Observable<WeatherResponse> weather( @Path("apiVersion") String apiVersion , @Query("q") String city, @Query("appid") String appId );

}

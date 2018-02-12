package com.example.prutko02.weatherapp.network.api;

import android.support.annotation.StringDef;

import com.example.prutko02.weatherapp.network.pojo.WeatherResponse;

import java.lang.annotation.Retention;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static java.lang.annotation.RetentionPolicy.SOURCE;


public interface WeatherApi {

    /**
     * Temperature is available in Fahrenheit, Celsius and Kelvin units.
     For temperature in Fahrenheit use units=imperial
     For temperature in Celsius use units=metric
     Temperature in Kelvin is used by default, no need to use units parameter in API call
     */
    @Retention(SOURCE)
    @StringDef({
            STANDARD,
            METRIC,
            IMPERIAL
    })
    @interface Units {}
    String STANDARD = "";
    String METRIC = "metric";
    String IMPERIAL = "imperial";

    @Retention(SOURCE)
    @StringDef({
            Arabic,
            Bulgarian,
            Catalan,
            Czech,
            German,
            Greek,
            English,
            Persian,
            Finnish,
            French,
            Galician,
            Croatian,
            Hungarian,
            Italian,
            Japanese,
            Korean,
            Latvian,
            Lithuanian,
            Macedonian,
            Dutch,
            Polish,
            Portuguese,
            Romanian,
            Russian,
            Swedish,
            Slovak,
            Slovenian,
            Spanish,
            Turkish,
            Ukrainian,
            Vietnamese,
            Chinese_Simplified,
            Chinese_Traditional
    })
    @interface Lang {}
    String Arabic = "ar";
    String Bulgarian = "bg";
    String Catalan = "ca";
    String Czech = "cz";
    String German = "de";
    String Greek = "el";
    String English = "en";
    String Persian = "fa";
    String Finnish = "fi";
    String French = "fr";
    String Galician = "gl";
    String Croatian = "hr";
    String Hungarian = "hu";
    String Italian = "it";
    String Japanese = "ja";
    String Korean = "kr";
    String Latvian = "la";
    String Lithuanian = "lt";
    String Macedonian = "mk";
    String Dutch = "nl";
    String Polish = "pl";
    String Portuguese = "pt";
    String Romanian = "ro";
    String Russian = "ru";
    String Swedish = "se";
    String Slovak = "sk";
    String Slovenian = "sl";
    String Spanish = "es";
    String Turkish = "tr";
    String Ukrainian = "ua";
    String Vietnamese = "vi";
    String Chinese_Simplified = "zh_cn";
    String Chinese_Traditional = "zh_tw";

    @GET("/data/{apiVersion}/weather")
    Observable<WeatherResponse> getWeather(@Path("apiVersion") String apiVersion , @Query("q") String city, @Query("units") String units, @Query("lang") String lang, @Query("appid") String appId );

}

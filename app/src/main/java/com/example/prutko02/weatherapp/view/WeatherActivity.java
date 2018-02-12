package com.example.prutko02.weatherapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.prutko02.weatherapp.R;
import com.example.prutko02.weatherapp.databinding.WeatherActivityBinding;
import com.example.prutko02.weatherapp.network.pojo.WeatherResponse;

import io.reactivex.disposables.CompositeDisposable;

public class WeatherActivity extends AppCompatActivity {

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.weather_activity);
        WeatherResponse weatherResponse = new WeatherResponse();
        binding.setWeatherResponse(weatherResponse);
    }


}

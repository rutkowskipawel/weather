package com.example.prutko02.weatherapp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.prutko02.weatherapp.R;
import com.example.prutko02.weatherapp.databinding.WeatherActivityBinding;
import com.example.prutko02.weatherapp.model.Weather;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.weather_activity);
        Weather weather = new Weather();
        binding.setWeather(weather);
    }
}

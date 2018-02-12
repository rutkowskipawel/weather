package com.example.prutko02.weatherapp.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.prutko02.weatherapp.R;
import com.example.prutko02.weatherapp.databinding.WeatherActivityBinding;

public class WeatherActivity extends AppCompatActivity {
    private WeatherActivityVM weatherActivityVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.weather_activity);
        weatherActivityVM = new WeatherActivityVM();
        binding.setViewModel(weatherActivityVM);
        weatherActivityVM.onPostCreate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        weatherActivityVM.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        weatherActivityVM.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        weatherActivityVM.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        weatherActivityVM.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        weatherActivityVM.onDestroy();
    }
}

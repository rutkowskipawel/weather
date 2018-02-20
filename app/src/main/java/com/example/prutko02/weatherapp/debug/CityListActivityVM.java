package com.example.prutko02.weatherapp.debug;

import com.example.prutko02.weatherapp.network.api.WeatherApiProxy;
import com.example.prutko02.weatherapp.utils.LogUtil;

import io.reactivex.disposables.CompositeDisposable;

/**
 * ViewModel class for {@link CityListActivity}
 */

public class CityListActivityVM {

    private static final String TAG =  CityListActivityVM.class.getSimpleName();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    void onStart() {
    }

    void onResume() {
    }


    void onPause() {
        compositeDisposable.dispose();
    }

    void onStop() {
    }

    void onDestroy() {
    }
}

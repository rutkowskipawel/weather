package com.example.prutko02.weatherapp.debug;

import io.reactivex.disposables.CompositeDisposable;

public class CityDetailVM {

    private static final String TAG =  CityDetailVM.class.getSimpleName();

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

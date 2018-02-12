package com.example.prutko02.weatherapp.view;

import android.databinding.ObservableField;
import android.util.Log;

import com.example.prutko02.weatherapp.model.Weather;
import com.example.prutko02.weatherapp.network.api.WeatherApiProxy;
import com.example.prutko02.weatherapp.network.pojo.WeatherResponse;
import com.example.prutko02.weatherapp.utils.DataMapper;
import com.example.prutko02.weatherapp.utils.LogUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class WeatherActivityVM {
    private static final String TAG =  WeatherActivityVM.class.getSimpleName();

    public ObservableField<String> currentCity = new ObservableField<>("Warszawa");
    public ObservableField<Weather> weather = new ObservableField<>(new Weather());

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    void onPostCreate() {
        if (!currentCity.get().isEmpty()) {
            try (Realm realm = Realm.getDefaultInstance()) {
                RealmResults<Weather> weatherRealmResults = realm.where(Weather.class).equalTo("cityName", currentCity.get()).findAllSorted("timestamp", Sort.DESCENDING);
                if (weatherRealmResults.size() > 0) {
                    Weather currentWeather = weatherRealmResults.first();
                    weather.set(realm.copyFromRealm(currentWeather));
                }
            }
        }
    }

    void onStart() {
    }

    void onResume() {
        if (!currentCity.get().isEmpty()) {
            compositeDisposable.add(
                    WeatherApiProxy.getWeather(currentCity.get())
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(new DisposableObserver<WeatherResponse>() {
                                @Override
                                public void onComplete() {
                                }

                                @Override
                                public void onError(Throwable e) {
                                    LogUtil.log(Log.ERROR, TAG, "Couldn't fetch weather data: " + e.getLocalizedMessage());
                                }

                                @Override
                                public void onNext(WeatherResponse weatherResponse) {
                                    try (Realm realm = Realm.getDefaultInstance()) {
                                        realm.executeTransaction(realm1 -> {
                                            Weather currentWeather = realm.where(Weather.class).equalTo("cityName", currentCity.get()).findFirst();
                                            if(currentWeather == null){
                                                currentWeather = realm.createObject(Weather.class, currentCity.get());
                                            }
                                            DataMapper.transformWeatherResponseToWeather(weatherResponse, currentWeather );
                                            weather.set(realm.copyFromRealm(currentWeather));
                                        });
                                    }
                                }
                            }));
        }
    }


    void onPause() {
        compositeDisposable.dispose();
    }

    void onStop() {
    }

    void onDestroy() {
    }
}

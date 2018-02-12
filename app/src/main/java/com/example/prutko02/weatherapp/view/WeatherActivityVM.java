package com.example.prutko02.weatherapp.view;

import android.databinding.ObservableField;

import com.example.prutko02.weatherapp.model.Weather;
import com.example.prutko02.weatherapp.network.api.WeatherApiProxy;
import com.example.prutko02.weatherapp.network.pojo.WeatherResponse;
import com.example.prutko02.weatherapp.utils.DataMapper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class WeatherActivityVM {
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

    void onDestroy() {
    }

    void onPause() {
        compositeDisposable.dispose();
    }

    void onStop() {
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
                                }

                                @Override
                                public void onNext(WeatherResponse weatherResponse) {
                                    try (Realm realm = Realm.getDefaultInstance()) {
                                        realm.executeTransaction(realm1 -> {
                                            Weather currentWeather = realm.where(Weather.class).equalTo("cityName", currentCity.get()).findFirst();
                                            if(weather == null){
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
}

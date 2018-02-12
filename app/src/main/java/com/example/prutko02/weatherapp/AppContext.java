package com.example.prutko02.weatherapp;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.prutko02.weatherapp.network.api.WeatherApi;
import com.example.prutko02.weatherapp.utils.LogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class AppContext extends Application {
    private static final String TAG = AppContext.class.getSimpleName();

    private static final String GSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    private static AppContext appContext;
    private static OkHttpClient okHttpClient;
    private static Gson gson;
    private static Retrofit retrofit;
    private static WeatherApi weatherApi;

    public AppContext() {
        appContext = this;
    }

    public static AppContext getAppContext() {
        return appContext;
    }

    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        }

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean networkAvailable = activeNetworkInfo != null && activeNetworkInfo.isConnected();

        LogUtil.log(Log.INFO, TAG, "Network available: " + networkAvailable);
        return networkAvailable;
    }

    public Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .setDateFormat(GSON_DATE_FORMAT)
                    .create();
        }
        return gson;
    }

    Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.OPEN_WEATHER_MAP_ENDPOINT)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .client(getOkHttpClient())
                    .build();
        }
        return retrofit;
    }

    public WeatherApi getWeatherApi() {
        if (weatherApi == null) {
            weatherApi = getRetrofit().create(WeatherApi.class);
        }
        return weatherApi;
    }

    public OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
//                    .addInterceptor(new Interceptor() {
//                @Override
//                public okhttp3.Response intercept(Chain chain) throws IOException {
//                    Request originalRequest = chain.request();
//
//                    Request.Builder builder = originalRequest.newBuilder().header("Authorization",
//                            Credentials.basic("user", "password"));
//
//                    Request newRequest = builder.build();
//                    return chain.proceed(newRequest);
//                }});

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
            builder.addInterceptor(logging);

            okHttpClient = builder.build();
        }
        return okHttpClient;
    }


}

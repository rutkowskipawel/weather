package com.example.prutko02.weatherapp.utils;

import android.util.Log;

/**
 * Proxy allowing to use other libraries for logging (e.g. sending logs to Crashlytics)
 */
public class LogUtil {

    public static void log(int priority, String tag, String msg) {
        Log.println(priority, tag, msg);
    }
}

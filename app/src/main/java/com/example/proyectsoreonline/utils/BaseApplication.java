package com.example.proyectsoreonline.utils;

import android.app.Application;
import android.content.Context;

import com.example.proyectsoreonline.BuildConfig;


import java.util.UUID;
import java.util.regex.Pattern;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class BaseApplication extends Application {
    private static final Pattern PATTERN = Pattern.compile("-");
    private static Context context;
    private static String deviceID;

    public static Context getAppContext() { return context; }
    public static String getDeviceID() {return deviceID; }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        deviceID = BuildConfig.DEBUG ?
                PATTERN.matcher(UUID.randomUUID().toString()).replaceAll("") :
                PATTERN.matcher(UUID.randomUUID().toString()).replaceAll("");
        deviceID = deviceID.substring(0, Math.min(deviceID.length(), 32));
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").build();
        Realm.setDefaultConfiguration(config);
    }

    @Override
    public void onTerminate() { super.onTerminate(); }

    @Override
    protected void attachBaseContext(Context context) { super.attachBaseContext(context); }
}
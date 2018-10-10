package net.androidbootcamp.pweatherapp;

import android.app.Application;

import net.androidbootcamp.pweatherapp.dagger.AppComponent;
import net.androidbootcamp.pweatherapp.dagger.AppModule;
import net.androidbootcamp.pweatherapp.dagger.DaggerAppComponent;

public class PWeatherApp extends Application {
    private final String beseUrl = "https://api.weatherbit.io/v2.0/";

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this, beseUrl))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

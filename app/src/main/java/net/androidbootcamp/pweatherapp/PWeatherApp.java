package net.androidbootcamp.pweatherapp;

import android.app.Application;

import net.androidbootcamp.pweatherapp.dagger.AppComponent;
import net.androidbootcamp.pweatherapp.dagger.AppModule;
import net.androidbootcamp.pweatherapp.dagger.DaggerAppComponent;

public class PWeatherApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

package net.androidbootcamp.pweatherapp.dagger;

import net.androidbootcamp.pweatherapp.PWeatherApp;

import dagger.Module;

@Module
public class AppModule {
    private PWeatherApp pWeatherApp;

    public AppModule(PWeatherApp pWeatherApp) {
        this.pWeatherApp = pWeatherApp;
    }
}

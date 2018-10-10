package net.androidbootcamp.pweatherapp.dagger;

import android.arch.persistence.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.androidbootcamp.pweatherapp.PWeatherApp;
import net.androidbootcamp.pweatherapp.db.Observation;
import net.androidbootcamp.pweatherapp.db.ObservationDatabase;
import net.androidbootcamp.pweatherapp.repositories.ObservationRepository;
import net.androidbootcamp.pweatherapp.retrofit.ObservationApi;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private PWeatherApp pWeatherApp;
    private String baseUrl;

    public AppModule(PWeatherApp pWeatherApp, String baseUrl) {
        this.pWeatherApp = pWeatherApp;
        this.baseUrl = baseUrl;
    }

    @Singleton
    @Provides
    PWeatherApp providesApp () {
        return this.pWeatherApp;
    }

    @Singleton
    @Provides
    Gson providesGson () {
        return new GsonBuilder().create();
    }

    @Singleton
    @Provides
    OkHttpClient providesOkHttp() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    ObservationApi providesObservationApi(Retrofit retrofit) {
        return retrofit.create(ObservationApi.class);
    }

    @Singleton
    @Provides
    ObservationDatabase providesObservationDatabase(PWeatherApp pWeatherApp) {
        return Room.databaseBuilder(pWeatherApp.getApplicationContext(),
                ObservationDatabase.class, ObservationDatabase.NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    ObservationRepository providesObservationRepository (PWeatherApp pWeatherApp,
                                                     ObservationApi observationApi,
                                                     ObservationDatabase observationDatabase) {
        return new ObservationRepository(pWeatherApp, observationApi, observationDatabase);
    }
}

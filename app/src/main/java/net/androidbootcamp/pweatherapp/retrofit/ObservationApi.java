package net.androidbootcamp.pweatherapp.retrofit;


import net.androidbootcamp.pweatherapp.retrofit.model.ObservationResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ObservationApi {

    @GET("current")
    ObservationResponse getCurrentWeather (@Query("key") String key,
                                           @Query("lang") String language,
                                           @Query("lat") double latitude,
                                           @Query("lon") double longitude);

    @GET("current")
    ObservationResponse getCurrentWeather (@Query("key") String key,
                                           @Query("lang") String language,
                                           @Query("city") String city);
}

package net.androidbootcamp.pweatherapp.retrofit;


import net.androidbootcamp.pweatherapp.retrofit.model.ObservationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ObservationApi {

    @GET("current")
    Call<ObservationResponse> getCurrentWeather (@Query("lat") double latitude,
                                                 @Query("lon") double longitude,
                                                 @Query("key") String key,
                                                 @Query("lang") String language);

    @GET("current")
    Call<ObservationResponse> getCurrentWeather (@Query("key") String key,
                                                 @Query("lang") String language,
                                                 @Query("city") String city);
}

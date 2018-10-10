package net.androidbootcamp.pweatherapp.repositories;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import net.androidbootcamp.pweatherapp.R;
import net.androidbootcamp.pweatherapp.db.ObservationDatabase;
import net.androidbootcamp.pweatherapp.db.Observation;
import net.androidbootcamp.pweatherapp.retrofit.ObservationApi;
import net.androidbootcamp.pweatherapp.retrofit.model.ObservationResponse;
import net.androidbootcamp.pweatherapp.retrofit.model.ObservationWebResponse;

import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ObservationRepository {

    private static final String LANGUAGE = "en";
    private ObservationApi mApi;
    private ObservationDatabase mDatabase;
    private Context mContext;

    @Inject
    public ObservationRepository (Context context, ObservationApi observationApi, ObservationDatabase observationDatabase) {
        mContext = context;
        mApi = observationApi;
        mDatabase = observationDatabase;
    }

    public LiveData<Observation> getObservation(String city) {
        String key = mContext.getResources().getString(R.string.api_key);
        return getObservation(key, LANGUAGE, city);
    }

    private LiveData<Observation> getObservation (String key, String language,String city) {

         mApi.getCurrentWeather(key, language, city).enqueue(new Callback<ObservationResponse>() {
            @Override
            public void onResponse(Call<ObservationResponse> call, Response<ObservationResponse> response) {

                if (response.isSuccessful()) {
                    ObservationWebResponse observationWebResponse = response.body().getObservationWebResponses().get(0);
                    mDatabase.observationDAO().setObservation(new Observation(observationWebResponse));
                }
            }

            @Override
            public void onFailure(Call<ObservationResponse> call, Throwable t) {
                // Todo: handle onFailure
            }
        });


        return mDatabase.observationDAO().getObservation();
    }
}

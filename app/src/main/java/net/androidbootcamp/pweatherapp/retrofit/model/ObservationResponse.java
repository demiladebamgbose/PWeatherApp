package net.androidbootcamp.pweatherapp.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ObservationResponse {
    @SerializedName("data")
    @Expose
    private List<Observation> observations;

    @SerializedName("count")
    @Expose
    private int count;

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

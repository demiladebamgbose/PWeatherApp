package net.androidbootcamp.pweatherapp.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ObservationResponse {
    @SerializedName("data")
    @Expose
    private List<ObservationWebResponse> observationWebResponses;

    @SerializedName("count")
    @Expose
    private int count;

    public List<ObservationWebResponse> getObservationWebResponses() {
        return observationWebResponses;
    }

    public void setObservationWebResponses(List<ObservationWebResponse> observationWebResponses) {
        this.observationWebResponses = observationWebResponses;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

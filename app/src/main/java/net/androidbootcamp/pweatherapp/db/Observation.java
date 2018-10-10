package net.androidbootcamp.pweatherapp.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.android.gms.maps.model.LatLng;

import net.androidbootcamp.pweatherapp.retrofit.model.ObservationWebResponse;

@Entity(tableName = ObservationDatabase.NAME)
public class Observation {
    @PrimaryKey
    private LatLng latLng;

    private String windCdir;
    private String timezone;
    private String time;
    private String countryCode;
    private String icon;
    private  String code;
    private String description;
    private String cityName;
    private String sunrise;
    private String sunset;
    private String temp;



    public Observation() {

    }

    public Observation(ObservationWebResponse observationWebResponse) {
        this.latLng = new LatLng(Double.valueOf(observationWebResponse.getLat()), Double.valueOf(observationWebResponse.getLon()));
        this.icon = observationWebResponse.getWeather().getIcon();
        this.code = observationWebResponse.getWeather().getCode();
        this.description = observationWebResponse.getWeather().getDescription();
        this.windCdir = observationWebResponse.getWindCdir();
        this.timezone = observationWebResponse.getTimezone();
        this.time = observationWebResponse.getTime();
        this.countryCode = observationWebResponse.getCountryCode();
        this.cityName = observationWebResponse.getCityName();
        this.sunrise = observationWebResponse.getSunrise();
        this.sunset = observationWebResponse.getSunset();
        this.temp = observationWebResponse.getTemp();
    }


    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getWindCdir() {
        return windCdir;
    }

    public void setWindCdir(String windCdir) {
        this.windCdir = windCdir;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}

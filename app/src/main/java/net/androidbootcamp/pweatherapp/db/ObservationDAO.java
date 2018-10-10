package net.androidbootcamp.pweatherapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Room;

import io.reactivex.Single;

@Dao
public interface ObservationDAO {

    @Query("Select * from observations")
    LiveData<Observation> getObservation();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setObservation(Observation observation);
}


package net.androidbootcamp.pweatherapp.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Observation.class}, version = 1)
public abstract class ObservationDatabase extends RoomDatabase {
    public static final String NAME = "observations";

    public abstract ObservationDAO observationDAO();
}

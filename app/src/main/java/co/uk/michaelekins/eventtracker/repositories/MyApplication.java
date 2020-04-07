package co.uk.michaelekins.eventtracker.repositories;

import android.content.Context;

import androidx.room.Room;

import co.uk.michaelekins.eventtracker.databases.AppDatabase;


public class MyApplication {

    private static MyApplication instance = null;


    public AppDatabase db;

    public MyApplication(Context context){
        db = Room.databaseBuilder(context, AppDatabase.class, "events-database").allowMainThreadQueries().build();

        if (instance == null) {
            instance = this;
        }
    }


    public static synchronized MyApplication getInstance() {
        return instance;
    }
}

package co.uk.michaelekins.eventtracker.repositories;

import co.uk.michaelekins.eventtracker.databases.AppDatabase;


public class DatabaseRepository {

    private static DatabaseRepository instance = null;


    public AppDatabase db;

    public DatabaseRepository(AppDatabase aDb){
        db = aDb;

        if (instance == null) {
            instance = this;
        }
    }


    public static synchronized DatabaseRepository getInstance() {
        return instance;
    }
}

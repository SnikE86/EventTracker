package co.uk.michaelekins.eventtracker.repositories;

import androidx.lifecycle.LiveData;


import java.util.List;

import co.uk.michaelekins.eventtracker.events.InstanceEvent;


public class EventsLiveData {

    public LiveData<List<InstanceEvent>> requestInstanceEvents() {
        DatabaseRepository myApp = DatabaseRepository.getInstance();

        return myApp.db.instanceEventDao().getAll();
    }

}
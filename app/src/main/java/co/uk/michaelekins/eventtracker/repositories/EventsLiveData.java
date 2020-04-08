package co.uk.michaelekins.eventtracker.repositories;

import androidx.lifecycle.LiveData;


import co.uk.michaelekins.eventtracker.events.InstanceEvent;


public class EventsLiveData {

    public LiveData<InstanceEvent> requestInstanceEvents() {
        DatabaseRepository myApp = DatabaseRepository.getInstance();

        return myApp.db.instanceEventDao().getAll();
    }

}
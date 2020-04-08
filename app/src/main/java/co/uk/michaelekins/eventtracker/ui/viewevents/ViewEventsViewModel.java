package co.uk.michaelekins.eventtracker.ui.viewevents;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import java.util.List;

import co.uk.michaelekins.eventtracker.events.InstanceEvent;
import co.uk.michaelekins.eventtracker.repositories.EventsLiveData;

public class ViewEventsViewModel extends ViewModel {

    private EventsLiveData eventsLiveData;
    public LiveData<List<InstanceEvent>> loadedInstanceEvents;

    public ViewEventsViewModel(){
        eventsLiveData = new EventsLiveData();
        loadedInstanceEvents = eventsLiveData.requestInstanceEvents();
    }

    public LiveData<List<InstanceEvent>> getLoadedInstances() {
        return loadedInstanceEvents;
    }
}
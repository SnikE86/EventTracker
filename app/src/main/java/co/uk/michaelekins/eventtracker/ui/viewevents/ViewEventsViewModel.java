package co.uk.michaelekins.eventtracker.ui.viewevents;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import co.uk.michaelekins.eventtracker.events.InstanceEvent;
import co.uk.michaelekins.eventtracker.repositories.EventsLiveData;

public class ViewEventsViewModel extends ViewModel {

    private EventsLiveData eventsLiveData;
    public LiveData<InstanceEvent> loadedInstanceEvents;

    public ViewEventsViewModel(){
        eventsLiveData = new EventsLiveData();
        loadedInstanceEvents = eventsLiveData.requestInstanceEvents();
    }

    public LiveData<InstanceEvent> getLoadedInstances() {
        return loadedInstanceEvents;
    }
}
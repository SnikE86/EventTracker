package co.uk.michaelekins.eventtracker.ui.viewevents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import co.uk.michaelekins.eventtracker.events.InstanceEvent;

public class EventSummaryViewModel extends ViewModel {
    public MutableLiveData<String> name;
    public MutableLiveData<String> date;
    public MutableLiveData<String> tags;

    public EventSummaryViewModel(){
        name = new MutableLiveData<String>();
        date = new MutableLiveData<String>();
        tags = new MutableLiveData<String>();
    }

    public LiveData<String> getName() {
        return name;
    }

    public LiveData<String> getDate() {
        return date;
    }

    public LiveData<String> getTags() {
        return tags;
    }

    public void seedInstanceEvent(InstanceEvent newInstanceEvent) {
        name.setValue(newInstanceEvent.name);
        date.setValue(newInstanceEvent.startDate.toString());
        tags.setValue(newInstanceEvent.tags.toString());
    }
}

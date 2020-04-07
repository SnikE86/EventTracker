package co.uk.michaelekins.eventtracker.ui.addevents;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AddEventsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AddEventsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is add events fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
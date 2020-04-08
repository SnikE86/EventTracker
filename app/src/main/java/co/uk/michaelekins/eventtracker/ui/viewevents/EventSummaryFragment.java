package co.uk.michaelekins.eventtracker.ui.viewevents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import co.uk.michaelekins.eventtracker.R;
import co.uk.michaelekins.eventtracker.events.InstanceEvent;
import co.uk.michaelekins.eventtracker.ui.home.HomeViewModel;

public class EventSummaryFragment extends Fragment {
    public EventSummaryViewModel eventSummaryViewModel;

    private TextView name;
    private TextView date;
    private TextView tags;

    public EventSummaryFragment(){
//        eventSummaryViewModel = new ViewModelProvider(this).get(EventSummaryViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        eventSummaryViewModel = new ViewModelProvider(this).get(EventSummaryViewModel.class);

        View root = inflater.inflate(R.layout.fragment_event_summary, container, false);

        //eventSummaryViewModel = new ViewModelProvider(this).get(EventSummaryViewModel.class);

        name = root.findViewById(R.id.text_event_summary_name);
        date = root.findViewById(R.id.text_event_summary_date);
        tags = root.findViewById(R.id.text_event_summary_tags);

        eventSummaryViewModel.getName().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                name.setText(s);
            }
        });

        eventSummaryViewModel.getDate().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                date.setText(s);
            }
        });

        eventSummaryViewModel.getTags().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tags.setText(s);
            }
        });

//        final Observer<LiveData<String>> loadedEventNameObserver = new Observer<LiveData<String>>() {
//            @Override
//            public void onChanged(LiveData<String> stringMutableLiveData) {
//                String s = stringMutableLiveData.getValue();
//                name.setText(s);
//            }
//        };
//        eventSummaryViewModel.getName().observe(this, loadedEventNameObserver);
//
//        final Observer<MutableLiveData<String>> loadedEventDateObserver = new Observer<MutableLiveData<String>>() {
//            @Override
//            public void onChanged(MutableLiveData<String> stringMutableLiveData) {
//                date.setText(stringMutableLiveData.getValue());
//            }
//        };
//        eventSummaryViewModel.getDate().observe(this, loadedEventDateObserver);
//
//        final Observer<MutableLiveData<String>> loadedEventTagsObserver = new Observer<MutableLiveData<String>>() {
//            @Override
//            public void onChanged(MutableLiveData<String> stringMutableLiveData) {
//                tags.setText(stringMutableLiveData.getValue());
//            }
//        };
//        eventSummaryViewModel.getTags().observe(this, loadedEventTagsObserver);

        return root;
    }
}

package co.uk.michaelekins.eventtracker.ui.viewevents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import co.uk.michaelekins.eventtracker.R;
import co.uk.michaelekins.eventtracker.databases.AppDatabase;
import co.uk.michaelekins.eventtracker.events.InstanceEvent;
import co.uk.michaelekins.eventtracker.ui.home.HomeViewModel;

public class ViewEventsFragment extends Fragment {

    private ViewEventsViewModel viewEventsViewModel;

    private TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        textView = root.findViewById(R.id.text_home);

        textView.setText("initial");
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewEventsViewModel = new ViewModelProvider(this).get(ViewEventsViewModel.class);

        final Observer<InstanceEvent> loadedInstanceEventsObserver = new Observer<InstanceEvent>() {
            @Override
            public void onChanged(@Nullable final InstanceEvent newInstanceEvent) {
//                InstanceEvent newInstanceEvent = newInstanceEvents.getValue();
                textView.setText(newInstanceEvent.name);
            }
        };

        viewEventsViewModel.getLoadedInstances().observe(this, loadedInstanceEventsObserver);

//        LiveData<InstanceEvent> newInstanceEvents = viewEventsViewModel.getLoadedInstances();
//        InstanceEvent newInstanceEvent = newInstanceEvents.getValue();
//        textView.setText(newInstanceEvent.name);

    }

}
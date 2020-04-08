package co.uk.michaelekins.eventtracker.ui.viewevents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import co.uk.michaelekins.eventtracker.R;
import co.uk.michaelekins.eventtracker.events.InstanceEvent;
import co.uk.michaelekins.eventtracker.repositories.EventsAdapter;

public class ViewEventsFragment extends Fragment {

    private ViewEventsViewModel viewEventsViewModel;

    private RecyclerView recyclerView;
    private EventsAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_view_events, container, false);

        viewEventsViewModel = new ViewModelProvider(this).get(ViewEventsViewModel.class);

        layoutManager = new LinearLayoutManager(this.getContext());

        recyclerView = root.findViewById(R.id.event_viewer_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new EventsAdapter();

        final Observer<List<InstanceEvent>> loadedInstanceEventsObserver = new Observer<List<InstanceEvent>>() {
            @Override
            public void onChanged(@Nullable final List<InstanceEvent> newInstanceEvents) {

                for (InstanceEvent newInstanceEvent : newInstanceEvents) {
                    mAdapter.addItem(newInstanceEvent);
                }
                mAdapter.notifyItemInserted(newInstanceEvents.size());
            }
        };

        viewEventsViewModel.getLoadedInstances().observe(this, loadedInstanceEventsObserver);

        recyclerView.setAdapter(mAdapter);

        return root;
    }
}
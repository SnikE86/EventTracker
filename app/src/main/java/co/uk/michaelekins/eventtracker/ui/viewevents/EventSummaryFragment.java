package co.uk.michaelekins.eventtracker.ui.viewevents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import co.uk.michaelekins.eventtracker.R;

public class EventSummaryFragment extends Fragment {
    public EventSummaryViewModel eventSummaryViewModel;

    private TextView name;
    private TextView date;
    private TextView tags;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        eventSummaryViewModel = new ViewModelProvider(this).get(EventSummaryViewModel.class);

        View root = inflater.inflate(R.layout.fragment_event_summary, container, false);

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
        return root;
    }
}

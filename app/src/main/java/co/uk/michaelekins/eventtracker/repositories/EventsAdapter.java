package co.uk.michaelekins.eventtracker.repositories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

import co.uk.michaelekins.eventtracker.R;
import co.uk.michaelekins.eventtracker.events.InstanceEvent;
import co.uk.michaelekins.eventtracker.ui.viewevents.EventSummaryFragment;

public class EventsAdapter  extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {
    private LinkedList<InstanceEvent> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View view;
        public MyViewHolder(View aview) {
            super(aview);
            view = aview;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public EventsAdapter() {
        mDataset = new LinkedList<InstanceEvent>();
    }

    public void addItem(InstanceEvent newInstanceEvent){
        mDataset.add(newInstanceEvent);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public EventsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View aview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_event_summary, parent, false);

        MyViewHolder vh = new MyViewHolder(aview);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView name = holder.view.findViewById((R.id.text_event_summary_name));
        TextView date = holder.view.findViewById((R.id.text_event_summary_date));
        TextView tags = holder.view.findViewById((R.id.text_event_summary_tags));

        InstanceEvent event = mDataset.get(position);

        name.setText("Name: " + mDataset.get(position).name);
        //date.setText(mDataset.get(position).startDate.toString());
        //tags.setText(mDataset.get(position).tags.toString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

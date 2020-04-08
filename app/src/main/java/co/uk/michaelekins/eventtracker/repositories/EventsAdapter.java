package co.uk.michaelekins.eventtracker.repositories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

import co.uk.michaelekins.eventtracker.R;
import co.uk.michaelekins.eventtracker.events.InstanceEvent;

public class EventsAdapter  extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {
    private LinkedList<InstanceEvent> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public MyViewHolder(View aview) {
            super(aview);
            view = aview;
        }
    }

    public EventsAdapter() {
        mDataset = new LinkedList<InstanceEvent>();
    }

    public void addItem(InstanceEvent newInstanceEvent){
        mDataset.add(newInstanceEvent);
    }

    @Override
    public EventsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        View aview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_event_summary, parent, false);

        MyViewHolder viewholder = new MyViewHolder(aview);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView name = holder.view.findViewById((R.id.text_event_summary_name));
        TextView date = holder.view.findViewById((R.id.text_event_summary_date));
        TextView tags = holder.view.findViewById((R.id.text_event_summary_tags));

        name.setText("Name: " + mDataset.get(position).name);
        //date.setText(mDataset.get(position).startDate.toString());
        //tags.setText(mDataset.get(position).tags.toString());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

package co.uk.michaelekins.eventtracker.events;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;

@Entity
public class InstanceEvent {
    @NonNull
    @PrimaryKey
    public int eventId;

    @ColumnInfo(name = "start_date_time")
    public Long startDate;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "tags")
    public List<String> tags;

    @ColumnInfo(name = "priority")
    public int priority;

    @ColumnInfo(name = "participants")
    public List<String> participants;

    @ColumnInfo(name = "notes")
    public String notes;
}

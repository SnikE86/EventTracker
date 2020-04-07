package co.uk.michaelekins.eventtracker.dataAccessors;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.uk.michaelekins.eventtracker.events.InstanceEvent;

@Dao
public interface InstanceEventDao {
    @Query("SELECT * FROM InstanceEvent")
    LiveData<InstanceEvent> getAll();

    @Insert
    void insertAll(InstanceEvent... instanceEvents);
}

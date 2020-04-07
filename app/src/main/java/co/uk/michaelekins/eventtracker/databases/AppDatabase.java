package co.uk.michaelekins.eventtracker.databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import co.uk.michaelekins.eventtracker.Converters.Converters;
import co.uk.michaelekins.eventtracker.dataAccessors.InstanceEventDao;
import co.uk.michaelekins.eventtracker.events.InstanceEvent;

@Database(entities = {InstanceEvent.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
        public abstract InstanceEventDao instanceEventDao();
}

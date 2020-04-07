package co.uk.michaelekins.eventtracker.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

import co.uk.michaelekins.eventtracker.databases.AppDatabase;
import co.uk.michaelekins.eventtracker.events.InstanceEvent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//public class EventsLiveData<InstanceEvent> extends LiveData<List<InstanceEvent>> {
    public class EventsLiveData {

        public LiveData<InstanceEvent> requestInstanceEvents() {
            MyApplication myApp = MyApplication.getInstance();

            return myApp.db.instanceEventDao().getAll();
        }

    }
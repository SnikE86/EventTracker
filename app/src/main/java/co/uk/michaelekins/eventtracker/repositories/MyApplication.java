package co.uk.michaelekins.eventtracker.repositories;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.room.Room;

import co.uk.michaelekins.eventtracker.databases.AppDatabase;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class MyApplication {

    private static MyApplication instance = null;


    public AppDatabase db;

    public MyApplication(Context context){
        Log.d("Ekins", "was created");
        db = Room.databaseBuilder(context, AppDatabase.class, "events-database").allowMainThreadQueries().build();

        if (instance == null) {
            instance = this;
        }
    }

//    @Override
//    public void onCreate() {
//        Log.d("Ekins", "was created");
//        super.onCreate();
//        //mInstance = this;
//    }

    public static synchronized MyApplication getInstance() {
        return instance;
    }

//    public boolean isNetworkAvailable() {
//        ConnectivityManager connectivityManager
//                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo activeNetworkInfo = null;
//        if (connectivityManager != null) {
//            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
//        }
//        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
//    }

//    public static Retrofit getRetrofitClient() {
//
//        Log.d("Ekins", "getRetrofirClient successfulyl called");
//
//        if (retrofit == null) {
//            retrofit = new Retrofit.Builder()
////                    .client(client)
////                    .addConverterFactory(ScalarsConverterFactory.create())
////                    .addConverterFactory(GsonConverterFactory.create())
//                    //.baseUrl(Constants.BASE_URL)
//                    .build();
//        }
//        return retrofit;
//    }

}

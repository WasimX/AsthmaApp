package com.braduni.wasim.asthmaapp;

import android.app.Application;
import androidx.room.Room;

//This is the main application class It is called only once and is a great place for initializing
// expensive instances
//Like database
    public class databaseini extends Application {

    static Database database;

    @Override
    public void onCreate() {
        super.onCreate();
        createDatabase();
    }


    //Creates a database instance
    private void createDatabase() {
        database = Room.databaseBuilder(this, Database.class, "asthma.db").build();
    }

    public static Database getDatabase() {
        return database;
    }
}

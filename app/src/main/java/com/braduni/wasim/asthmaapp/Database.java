package com.braduni.wasim.asthmaapp;

import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;



//This is the abstract representation of our database
//entities shows table names
@androidx.room.Database(entities = {LogRecords.class}, exportSchema = false, version = 1)
@TypeConverters({Converters.class})
public abstract   class Database extends RoomDatabase {
    public abstract LogsDAO getDao();
}

//Data Access Object

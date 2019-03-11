package com.braduni.wasim.asthmaapp;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;


//This class contains all the operations that we can perform on our database
@Dao
public interface LogsDAO {

    @Insert
    void saveLogs(LogRecords logRecord);

    @Query("Select * from LogRecords")
    List<LogRecords> getAllLogs();


    @Query("SELECT COUNT(*) FROM LogRecords ")
    int getRecords();

    @Query("Select * from LogRecords Where date LIKE :date")
    LogRecords getDatabasedOnDate(String date);

    @Delete
    void deleteData(LogRecords logRecord);

}

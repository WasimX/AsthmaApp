package com.braduni.wasim.asthmaapp;

import java.util.Map;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


//This class is actually a table structure
//@Entity represents table
//and the variables represents columns
//@Primarykey means this column is  our primary key
@Entity
public class LogRecords{

    @PrimaryKey(autoGenerate = true)
    int record_id;
    Map<String, String> map;

    String date;

    int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}

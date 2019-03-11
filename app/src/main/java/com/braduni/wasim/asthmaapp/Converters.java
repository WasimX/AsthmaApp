package com.braduni.wasim.asthmaapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

import androidx.room.TypeConverter;


//Database only supports long, int, float, double
//It does not support map
//In order to support map we use type converter
public class Converters {

    @TypeConverter
    public static Map<String, String> fromString(String value) {
        Type listType = new TypeToken<Map<String, String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromMap(Map<String, String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}

package com.braduni.wasim.asthmaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LogSymptomsDatabase extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "log_symptoms";
    private static final String ID = "ID";
    private static final String Question_1 = "Question 1";
    private static final String Question_2 = "Question 2";
    private static final String Question_3 = "Question 3";
    private static final String add_notes = "addtional notes";

    public LogSymptomsDatabase(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOG_SYMPTOMS_TABLE = "CREATE TABLE " + TABLE_NAME +
                "("
                + " ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Question_1 + " TEXT,"
                + Question_2 + " TEXT,"
                + Question_3 + " TEXT"
                + add_notes + " TEXT"
                + ")";
        db.execSQL(CREATE_LOG_SYMPTOMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addLog(String q1, String q2, String q3,String notes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Question_1,q1);
        values.put(Question_2,q2);
        values.put(Question_3,q3);
        values.put(add_notes,notes);

        long result = db.insert(TABLE_NAME,null, values);

        if (result == -1){
            return false;
        } else {
            return true;
        }


        }
}

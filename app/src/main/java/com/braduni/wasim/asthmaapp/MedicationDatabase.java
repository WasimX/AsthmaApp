package com.braduni.wasim.asthmaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MedicationDatabase extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MedicationDatabase";

    // Table name
    private static final String TABLE_Medication = "MedicationTable";

    // Table Columns names
    private static final String ID = "id";
    private static final String Preventer = "Preventer";
    private static final String P_Morning = "P_Morning";
    private static final String P_Night = "P_Night";
    private static final String Reliever = "Reliever";
    private static final String R_Puffs = "R_Puffs";

    public MedicationDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MEDICATION_TABLE = "CREATE TABLE " + TABLE_Medication +
                "("
                + ID + "INT"
                + Preventer + " TEXT,"
                + P_Morning + " TEXT,"
                + P_Night + " TEXT,"
                + Reliever + " TEXT,"
                + R_Puffs + " TEXT" + ")";
        db.execSQL(CREATE_MEDICATION_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        if (oldVersion >= newVersion)
            return;
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Medication);

        // Create tables again
        onCreate(db);
    }

    // Adding new medication
    public int addMedication(medication medication) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Preventer, medication.getPreventer());
        values.put(P_Morning, medication.getP_Morning());
        values.put(P_Night, medication.getP_Night());
        values.put(Reliever, medication.getReliever());
        values.put(R_Puffs, medication.getR_Puffs());

        // Inserting Row
        long ID = db.insert(TABLE_Medication, null, values);
        db.close();
        return (int) ID;
    }

    // Updating single Medication
    public int updateMedication(medication medication) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Preventer, medication.getPreventer());
        values.put(P_Morning, medication.getP_Morning());
        values.put(P_Night, medication.getP_Night());
        values.put(Reliever, medication.getReliever());
        values.put(R_Puffs, medication.getR_Puffs());


        // Updating row
        return db.update(TABLE_Medication, values, ID + "=?",
                new String[]{String.valueOf(medication.getID())});
    }


}

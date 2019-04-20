package com.braduni.wasim.asthmaapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    private TextView mPreventer;
    private TextView mP_Morning;
    private TextView mP_Night;
    private TextView mReliever;
    private TextView mR_Puffs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mPreventer = findViewById(R.id.preventer);
        mP_Morning = findViewById(R.id.morning);
        mP_Night = findViewById(R.id.night);
        mReliever = findViewById(R.id.reliever);
        mR_Puffs = findViewById(R.id.puffs);


    }

    // On clicking the save button
    public void saveMedication() {
        MedicationDatabase mdb = new MedicationDatabase(this);

        // Creating Reminder
        int ID = mdb.addMedication(new medication(mPreventer, mP_Morning, mP_Night, mReliever, mR_Puffs));


        // Create toast to confirm new reminder
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();


    }
}
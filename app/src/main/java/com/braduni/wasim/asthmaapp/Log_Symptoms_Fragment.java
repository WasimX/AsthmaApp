package com.braduni.wasim.asthmaapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

public class Log_Symptoms_Fragment extends Fragment  {

    SQLiteDatabase db;

    RadioButton q1_1, q1_2, q1_3, q1_4, q1_5,
            q2_1, q2_2, q2_3, q2_4, q2_5,
            q3_1, q3_2, q3_3, q3_4, q3_5;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_log_symptoms, container, false);

    }

    public void RadioButtonClicked(View view) {

//This variable will store the reply to the questions
        String q1 = "";
        String q2 = "";
        String q3 = "";
// Check that the button is  now checked?
        boolean checked = ((RadioButton) view).isChecked();

// Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1_1:
                if (checked)
                    q1 = "Wheezing";
                break;
            case R.id.q1_2:
                if (checked)
                    q1 = "Phlegm/Mucus";
                break;
            case R.id.q1_3:
                if (checked)
                    q1 = "coughing";
                break;
            case R.id.q1_4:
                if (checked)
                    q1 = "difficulties_breathing";
                break;
            case R.id.q1_5:
                if (checked)
                    q1 = "difficulties_sleeping";
                break;


            case R.id.q2_1:
                if (checked)
                    q2 = "bad";
                break;
            case R.id.q2_2:
                if (checked)
                    q2 = "not_good";
                break;
            case R.id.q2_3:
                if (checked)
                    q2 = "good";
                break;
            case R.id.q2_4:
                if (checked)
                    q2 = "very_good";
                break;
            case R.id.q2_5:
                if (checked)
                    q2 = "excellent";
                break;


            case R.id.q3_1:
                if (checked)
                    q3 = "bad";
                break;
            case R.id.q3_2:
                if (checked)
                    q3 = "not_good";
                break;
            case R.id.q3_3:
                if (checked)
                    q3 = "good";
                break;
            case R.id.q3_4:
                if (checked)
                    q3 = "very_good";
                break;
            case R.id.q3_5:
                if (checked)
                    q3 = "excellent";
                break;


        }
        db.execSQL("INSERT INTO log_symptoms VALUES('" + q1 + "" + q2 + "" + q3 + "');");
    }
}

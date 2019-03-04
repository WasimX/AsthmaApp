package com.braduni.wasim.asthmaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Log_Symptoms_Fragment extends Fragment {

    LogSymptomsDatabase db;

    RadioGroup Q1;
    RadioGroup Q2;
    RadioGroup Q3;
    MultiAutoCompleteTextView add_notes;

    Button btn_save;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_log_symptoms, container, false);

        btn_save = v.findViewById(R.id.btn_save);
        int q1 = Q1.getCheckedRadioButtonId();
        int q2 = Q1.getCheckedRadioButtonId();
        int q3 = Q1.getCheckedRadioButtonId();
        Q1 = (RadioGroup)v.findViewById(q1);
        Q2 = (RadioGroup)v.findViewById(q2);
        Q3 = (RadioGroup)v.findViewById(q3);
        add_notes = v.findViewById(R.id.add_notes);
        btn_save = (Button) v.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {

            }
        });

        addData();

        return v;
    }

    public void addData() {
        btn_save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = db.addLog(Q1.toString(), Q2.toString(), Q3.toString(), add_notes.toString());

                        if (isInserted == true) {
                            Toast.makeText(getContext(), "Data inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getContext(), "Data not inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
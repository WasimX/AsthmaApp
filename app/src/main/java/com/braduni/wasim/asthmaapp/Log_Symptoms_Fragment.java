package com.braduni.wasim.asthmaapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Log_Symptoms_Fragment extends Fragment  implements View.OnClickListener {

    SQLiteDatabase db;

    RadioButton q1_1, q1_2, q1_3, q1_4, q1_5,
            q2_1, q2_2, q2_3, q2_4, q2_5,
            q3_1, q3_2, q3_3, q3_4, q3_5;

    RadioGroup Q1, Q2, Q3;
    Button btn_save;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_log_symptoms, container, false);

        btn_save = (Button) v.findViewById(R.id.btn_save);

        btn_save.setOnClickListener((View.OnClickListener) getContext());
        Q1.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) getContext());
        Q2.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) getContext());
        Q3.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) getContext());

        return v;
    }

    @Override
    public void onClick(View v) {
        Q1=(RadioGroup)v.findViewById(R.id.Q1);
        //String radiovalue = ((RadioButton)this.findViewById(Q1.getCheckedRadioButtonId())).getText().toString();
    }
}
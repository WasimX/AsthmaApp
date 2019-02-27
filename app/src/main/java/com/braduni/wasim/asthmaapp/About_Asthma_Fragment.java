package com.braduni.wasim.asthmaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class About_Asthma_Fragment extends Fragment implements View.OnClickListener {

    private ImageButton image_button_trigger;
    private ImageButton image_button_medication;
    private ImageButton image_button_moreinfo;
    private ImageButton image_button_symptoms;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.activity_about_asthma, container, false);

        image_button_trigger = rootview.findViewById(R.id.image_button_trigger);
        image_button_medication = rootview.findViewById(R.id.image_button_medication);
        image_button_moreinfo = rootview.findViewById(R.id.image_button_moreinfo);
        image_button_symptoms = rootview.findViewById(R.id.image_button_symptoms);

        image_button_trigger .setOnClickListener(this);
        image_button_medication.setOnClickListener(this);
        image_button_moreinfo .setOnClickListener(this);
        image_button_symptoms .setOnClickListener(this);

        return rootview;
    }

    @Override
    public void onClick(View v) {

        if( v == image_button_trigger) {
            startActivity(new Intent(getActivity(), TriggerActivity.class));
        }

        if ( v == image_button_medication) {
            startActivity(new Intent(getActivity(), MedicationActivity.class));
        }

        if ( v == image_button_moreinfo) {
            startActivity(new Intent(getActivity(), More_infoActivity.class));
        }

        if ( v == image_button_symptoms) {

            startActivity(new Intent(getActivity(), Symptoms_infoActivity.class));
        }
    }
}


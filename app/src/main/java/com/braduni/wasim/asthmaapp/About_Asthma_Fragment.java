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
import android.widget.Toast;

public class About_Asthma_Fragment extends Fragment implements View.OnClickListener {

    private ImageButton image_button_trigger;
    private ImageButton image_button_important;
    private ImageButton image_button_medication;
    private ImageButton image_button_moreinfo;
    private ImageButton image_button_symptoms;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.activity_about_asthma, container, false);

        image_button_trigger = rootview.findViewById(R.id.image_button_trigger);
        image_button_important = rootview.findViewById(R.id.image_button_important);
        image_button_medication = rootview.findViewById(R.id.image_button_medication);
        image_button_moreinfo = rootview.findViewById(R.id.image_button_moreinfo);
        image_button_symptoms = rootview.findViewById(R.id.image_button_symptoms);

        image_button_trigger .setOnClickListener(this);
        image_button_important .setOnClickListener(this);
        image_button_medication.setOnClickListener(this);
        image_button_moreinfo .setOnClickListener(this);
        image_button_symptoms .setOnClickListener(this);

        return rootview;
    }


    @Override
    public void onClick(View v) {

        if( v == image_button_trigger) {
            Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(this, test.class));
        }

        if ( v == image_button_important) {
            Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(this, test.class));
        }

        if ( v == image_button_medication) {
            Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
           // startActivity(new Intent(this, test.class));
        }

        if ( v == image_button_moreinfo) {
            Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
           // startActivity(new Intent(this, test.class));
        }

        if ( v == image_button_symptoms) {
            Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
           // startActivity(new Intent(this, test.class));
        }

    }


}


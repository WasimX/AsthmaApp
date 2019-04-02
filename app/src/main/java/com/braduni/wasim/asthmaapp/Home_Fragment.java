package com.braduni.wasim.asthmaapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class Home_Fragment extends Fragment implements View.OnClickListener {

    private ImageButton image_button_symptoms;
    private ImageButton image_button_history;
    private ImageButton image_button_reminder;
    private ImageButton image_button_about;
    private ImageButton image_button_support;
    private ImageButton image_button_contactus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_home, container, false);

        image_button_symptoms = v.findViewById(R.id.symptoms_btn);
        image_button_history = v.findViewById(R.id.history_btn);
        image_button_reminder = v.findViewById(R.id.reminder_btn);
        image_button_about = v.findViewById(R.id.about_asthma_btn);
        image_button_support = v.findViewById(R.id.support_btn);
        image_button_contactus = v.findViewById(R.id.contact_us_btn);

        image_button_symptoms.setOnClickListener(this);
        image_button_history.setOnClickListener(this);
        image_button_reminder .setOnClickListener(this);
        image_button_about .setOnClickListener(this);
        image_button_support .setOnClickListener(this);
        image_button_contactus .setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        if( v == image_button_symptoms) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, new Log_Symptoms_Fragment()).addToBackStack(null).commit();
        }

        if ( v == image_button_history) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, new History_Fragment()).addToBackStack(null).commit();
        }

        if ( v == image_button_reminder) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, new Reminder_Fragment()).addToBackStack(null).commit();
        }

        if ( v == image_button_about) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, new About_Asthma_Fragment()).addToBackStack(null).commit();
        }

        if ( v == image_button_support) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, new Em_Support_Fragment()).addToBackStack(null).commit();
        }

        if ( v == image_button_contactus) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, new Contact_us_Fragment()).addToBackStack(null).commit();
        }
    }
}

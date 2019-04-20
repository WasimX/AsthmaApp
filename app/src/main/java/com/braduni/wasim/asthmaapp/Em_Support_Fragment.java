package com.braduni.wasim.asthmaapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Em_Support_Fragment extends Fragment implements View.OnClickListener {

    private ImageButton image_button_AFA;
    private ImageButton image_button_VAP;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_em_support, container, false);

        image_button_AFA = view.findViewById(R.id.image_button_AFA);
        image_button_VAP = view.findViewById(R.id.image_button_VAP);

        image_button_AFA.setOnClickListener(this);
        image_button_VAP.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {

        if (v == image_button_AFA) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, new FirstAidActivity()).addToBackStack(null).commit();
        }

        if (v == image_button_VAP) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container, new ActionPlanActivity()).addToBackStack(null).commit();
        }
    }
}


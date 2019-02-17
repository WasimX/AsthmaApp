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

public class Em_Support_Fragment extends Fragment implements View.OnClickListener {

    private ImageButton image_button_AFA;
    private ImageButton image_button_VAP;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.activity_em_support, container, false);

        image_button_AFA = rootview.findViewById(R.id.image_button_AFA);
        image_button_VAP = rootview.findViewById(R.id.image_button_VAP);

        image_button_AFA.setOnClickListener(this);
        image_button_VAP.setOnClickListener(this);

        return rootview;
    }


    @Override
    public void onClick(View v) {

        if (v == image_button_AFA) {
            //Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), FirstAidActivity.class));
        }

        if (v == image_button_VAP) {
            // Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getActivity(), ActionPlanActivity.class));
        }
    }
}


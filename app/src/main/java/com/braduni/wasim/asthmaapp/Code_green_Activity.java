package com.braduni.wasim.asthmaapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Code_green_Activity extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewLayout = inflater.inflate(R.layout.fragment_code_green, container, false);

        TextView best_peak = viewLayout.findViewById(R.id.best_peak);
        TextView preventer = viewLayout.findViewById(R.id.preventer);
        TextView m_puff = viewLayout.findViewById(R.id.m_puff);
        TextView n_puff = viewLayout.findViewById(R.id.n_puff);
        TextView reliever_name = viewLayout.findViewById(R.id.reliever_name);
        TextView reliever_puff = viewLayout.findViewById(R.id.reliever_puff);

        best_peak.setText("1");
        preventer.setText("Example Medication");
        m_puff.setText("3");
        n_puff.setText("4");
        reliever_name.setText("Example Medication");
        reliever_puff.setText("6");

        return viewLayout;

    }
}



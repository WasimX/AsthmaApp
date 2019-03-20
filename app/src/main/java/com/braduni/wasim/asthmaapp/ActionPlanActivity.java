package com.braduni.wasim.asthmaapp;

import android.os.Bundle;
        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;

public class ActionPlanActivity extends Fragment implements View.OnClickListener {

    private Button code_green;
    private Button code_yellow;
    private Button code_red;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_action_plan, container, false);

        code_green = v.findViewById(R.id.code_green_btn);
        code_yellow = v.findViewById(R.id.code_yellow_btn);
        code_red = v.findViewById(R.id.code_red_btn);

        code_green.setOnClickListener(this);
        code_yellow.setOnClickListener(this);
        code_red .setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        if( v == code_green) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_code, new Code_green_Activity()).commit();
        }

        if ( v == code_yellow) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_code, new Code_yellow_Activity()).commit();
        }

        if ( v == code_red) {
            FragmentManager manager = getFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_code, new Code_red_Activity()).commit();
        }
    }
}

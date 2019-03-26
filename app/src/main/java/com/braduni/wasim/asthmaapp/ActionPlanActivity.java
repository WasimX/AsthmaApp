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
import android.widget.TextView;

public class ActionPlanActivity extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_action_plan, container, false);

        TextView preventer = v.findViewById(R.id.preventer);
        TextView m_puff = v.findViewById(R.id.m_puff);
        TextView n_puff = v.findViewById(R.id.n_puff);
        TextView reliever_name = v.findViewById(R.id.reliever_name);
        TextView reliever_puff = v.findViewById(R.id.reliever_puff);


        preventer.setText("Example Medication");
        m_puff.setText("3");
        n_puff.setText("4");
        reliever_name.setText("Example Medication");
        reliever_puff.setText("6");


        return v;
    }
}

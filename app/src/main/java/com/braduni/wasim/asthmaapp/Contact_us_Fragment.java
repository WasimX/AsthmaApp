package com.braduni.wasim.asthmaapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Contact_us_Fragment extends Fragment implements View.OnClickListener{


    private TextView tel_number;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewLayout = inflater.inflate(R.layout.activity_contact_us, container, false);

        tel_number = viewLayout.findViewById(R.id.tel_number);
        tel_number.setOnClickListener(this);

        return viewLayout;
    }

    @Override
    public void onClick(View v) {
        openDialer();
    }

    protected void openDialer(){

        Intent intent = new Intent(Intent.ACTION_DIAL);

        intent.setData(Uri.parse("tel:" + "03002225800"));
        // Start the dialer app activity with number
        startActivity(intent);
    }
}

package com.braduni.wasim.asthmaapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Contact_us_Fragment extends Fragment implements View.OnClickListener{


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewLayout = inflater.inflate(R.layout.activity_contact_us, container, false);

        TextView tel_number = viewLayout.findViewById(R.id.tel_number);
        TextView asthmaUK_email = viewLayout.findViewById(R.id.asthmaUK_email);
        TextView asthamUK_website = viewLayout.findViewById(R.id.asthamUK_website);

        tel_number.setOnClickListener(this);
        asthmaUK_email.setOnClickListener(this);
        asthamUK_website.setOnClickListener(this);

        return viewLayout;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tel_number:
                openDialer();
                break;
            case R.id.asthmaUK_email:
                openEmail();
                break;
            case R.id.asthamUK_website:
                openLink();
                break;
        }
    }

    protected void openDialer(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "03002225800")); //helpline number should appear on phone dailer
        // Start the dialer app activity with number
        startActivity(intent);
    }

    protected void openEmail() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri data = Uri.parse("mailto:recipient@example.com"); // Change email here - opens up email app with <-- email address
        intent.setData(data);
        startActivity(intent);
    }

    protected void openLink() {
        String url = "https://www.asthma.org.uk/advice/resources/helpline/"; //Link to the helpline page
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}

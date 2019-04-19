package com.braduni.wasim.asthmaapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

public class SplashscreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME = 4000; //This is 4 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //Code to start timer and take action after the timer ends
        new Handler().postDelayed(() -> {
            //Do any action here. Now we are moving to next page
            Intent mySuperIntent = new Intent(SplashscreenActivity.this, LoginActivity.class);
            startActivity(mySuperIntent);
            /* This 'finish()' is for exiting the app when back button pressed
             *  from Home page which is ActivityHome
             */
            finish();
        }, SPLASH_TIME);
    }
}

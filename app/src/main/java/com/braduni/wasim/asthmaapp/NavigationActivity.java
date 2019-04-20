package com.braduni.wasim.asthmaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView txtName, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View navHeader = navigationView.getHeaderView(0);
        ImageView imageView = navHeader.findViewById(R.id.user_photo);
        txtName = navHeader.findViewById(R.id.login_username);
        txtEmail = navHeader.findViewById(R.id.login_email);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Home_Fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        // load nav menu header data
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        assert user != null;
        loadNavHeader(user);


    }

    private void loadNavHeader(FirebaseUser user) {
        // name, email, picture
        txtName.setText(user.getDisplayName());
        txtEmail.setText(user.getEmail());
        //String imgurl = user.getPhotoUrl().toString();


// TODO: 05/03/2019
// crashes app when imgurl = to empty string
        // Loading profile image
        //Glide.with(this).load(imgurl)
        //        .crossFade()
        //        .thumbnail(0.5f)
        //        .bitmapTransform(new CircleTransform(this))
        //        .diskCacheStrategy(DiskCacheStrategy.ALL)
        //        .into(imageView);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_setting){
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsActivity()).addToBackStack(null).commit();
            startActivity(new Intent(this, SettingsActivity.class));
        }

        if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(NavigationActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_log_symptoms) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Log_Symptoms_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_history) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new History_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_reminder) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Reminder_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_em_support) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Em_Support_Fragment()).addToBackStack(null).commit();
        }  else if (id == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new About_Asthma_Fragment()).addToBackStack(null).commit();
        } else if (id == R.id.contact_us) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Contact_us_Fragment()).addToBackStack(null).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

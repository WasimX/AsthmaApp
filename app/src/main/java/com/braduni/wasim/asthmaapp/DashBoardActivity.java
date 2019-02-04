package com.braduni.wasim.asthmaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class DashBoardActivity extends AppCompatActivity implements  View.OnClickListener {

    private Button btn_sign_out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        btn_sign_out = findViewById(R.id.btn_sign_out);

        btn_sign_out.setOnClickListener(this);


    }

    private void signout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(DashBoardActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if( v == btn_sign_out) {
            signout();
        }else
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();



    }
}

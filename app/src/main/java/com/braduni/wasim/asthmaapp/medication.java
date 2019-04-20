package com.braduni.wasim.asthmaapp;

import android.widget.TextView;

// medication class
public class medication {

    private int mID;
    private String mPreventer;
    private String mP_Morning;
    private String mP_Night;
    private String mReliever;
    private String mR_Puffs;

    public medication(int ID, String Preventer, String P_Morning, String P_Night, String Reliever, String R_Puffs) {
        mID = ID;
        mPreventer = Preventer;
        mP_Morning = P_Morning;
        mP_Night = P_Night;
        mReliever = Reliever;
        mR_Puffs = R_Puffs;
    }

    public medication(TextView mPreventer, TextView mP_Morning, TextView mP_Night, TextView mReliever, TextView mR_Puffs) {
    }

    public Integer getID() {
        return mID;
    }

    public String getPreventer() {
        return mPreventer;
    }

    public String getP_Morning() {
        return mP_Morning;
    }

    public String getP_Night() {
        return mP_Night;
    }

    public String getReliever() {
        return mReliever;
    }

    public String getR_Puffs() {
        return mR_Puffs;
    }
}



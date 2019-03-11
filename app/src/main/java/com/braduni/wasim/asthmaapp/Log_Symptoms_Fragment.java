package com.braduni.wasim.asthmaapp;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;



//This fragment is for showing the question to user and then asks for the user fedback
public class Log_Symptoms_Fragment extends Fragment {

    RadioGroup q1_group, q2_group;
    TextView q1_txt, q2_txt;
    Button save;

    public Log_Symptoms_Fragment() {
        // Required empty public constructor
    }



    View itemView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        itemView = inflater.inflate(R.layout.activity_log_symptoms, container, false);
        initViews();
        attachClickListeners();
        return itemView;
    }


    //This attack listener to the save button
    private void attachClickListeners() {


        save.setOnClickListener(save_btn_click_listener);
    }


    //Here we initiate the views that we use
    private void initViews() {
        q1_group = itemView.findViewById(R.id.RG_Q1);
        q2_group = itemView.findViewById(R.id.RG_Q2);

        q1_txt = itemView.findViewById(R.id.log_q1_txt);
        q2_txt = itemView.findViewById(R.id.log_q2_txt);

        save = itemView.findViewById(R.id.btn_save);


    }



    //This block of code works on a separate thread so that the app does not hangs
    //It is advisable that when you save data in database use a worker thread instead of UI thread

    private AsyncTask<LogRecords, Void, Void> save_Asthma_Record_async = new AsyncTask<LogRecords, Void, Void>() {

        //This method will do its work in worker thread
        @Override
        protected Void doInBackground(LogRecords... logRecords) {
            databaseini.getDatabase().getDao().saveLogs(logRecords[0]);
            return null;
        }


        //This method works on main thread/UI Thread
        //It is called when the work on the worker thread completes
        @Override
        protected void onPostExecute(Void Void) {
            showToast("Record Added Successfully");
        }
    };




    //Listener for the save button
    //These lines of code will work when the user clicks on a save button
    View.OnClickListener save_btn_click_listener = v->{

        LogRecords logRecord = new LogRecords();
        String date = "";
        Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DAY_OF_MONTH)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR);
        logRecord.setDate(date);
        Map<String, String> map = getMap();
        logRecord.setMap(map);

        logRecord.setColor(getColor());



        //Sends data to be saved in database using asynchronous operation
        save_Asthma_Record_async.execute(logRecord);
    };



    //This method checks which answer is selected
    //So i will ask the radio group which index is selected and based on  it i will save the color
    private int getColor() {
        switch (q2_group.indexOfChild(itemView.findViewById(q2_group.getCheckedRadioButtonId()))) {
            case 0:
                return Color.BLUE;
            case 1:
                return  Color.RED;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.MAGENTA;
            default:
                return Color.BLACK;
        }
    }

    //Map saves data in a key value pair which is efficient way of saving data
    //Also using map i can get what user have selected in response to a question
    private Map<String, String> getMap() {

        RadioButton radioButton_1_selected = itemView.findViewById(q1_group.getCheckedRadioButtonId());
        RadioButton radioButton_2_selected = itemView.findViewById(q2_group.getCheckedRadioButtonId());

        Map<String, String> map = new HashMap<>();
        map.put(q1_txt.getText().toString(), radioButton_1_selected.getText().toString());
        map.put(q2_txt.getText().toString(), radioButton_2_selected.getText().toString());
        return map;

    }

    //This shows message to  the user
    private  void showToast(String record_added_successfully) {
        Toast.makeText(itemView.getContext(), record_added_successfully, Toast.LENGTH_SHORT).show();
    }



}

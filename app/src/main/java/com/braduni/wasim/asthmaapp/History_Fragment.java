package com.braduni.wasim.asthmaapp;

import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class History_Fragment extends Fragment {

    View itemViews;

    //MaterialCalendarView materialCalendarView;
    RecyclerView recyclerView;
    CalendarView calendarView;
    private LogsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        itemViews = inflater.inflate(R.layout.activity_history, container, false);
        initViews();
        //This method gets data from database
        getData();
        return itemViews;
    }


    //We  need to get data asynchronously so that the UI thread doesn't gets blocked
    private void getData() {
        new GetAllData().execute();
    }

    private void initViews() {

        recyclerView = itemViews.findViewById(R.id.history_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(itemViews.getContext(), RecyclerView.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(itemViews.getContext(), RecyclerView.VERTICAL));

        adapter = new LogsAdapter();

        recyclerView.setAdapter(adapter);

        calendarView = itemViews.findViewById(R.id.history_calendar);
        calendarView.setOnDayClickListener(new OnDayClickListener() {


            //When the user clicks on any date this method will call
            @Override
            public void onDayClick(EventDay eventDay) {
                eventDay.getCalendar().getTime();


                //This method gets the record against the data picked by the user
                new GetSpecificData().execute(eventDay.getCalendar().getTime());
            }
        });


    }



    //This method gets the record against the date user picked

    public class GetSpecificData extends AsyncTask<Date, Void, LogRecords> {
        @Override
        protected LogRecords doInBackground(Date... dates) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dates[0]);

            String date = "";
            //It does preprocessing on date and sends to database to get data
            date = calendar.get(Calendar.DAY_OF_MONTH)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR);
            return databaseini.getDatabase().getDao().getDatabasedOnDate(date);
        }

        @Override
        protected void onPostExecute(LogRecords logRecord) {

            //After getting data it sends data to adapter to show it on screen
            List<LogRecords> list = new ArrayList<>();
            if (logRecord == null) {
                adapter.setList(new ArrayList<>());
                return;
            }
            list.add(logRecord);
            adapter.setList(list);
        }
    }




    //This block of code run in background this will get all the dates and show it to user

    public class GetAllData extends AsyncTask<Void, Void, List<EventDay>> {

        @Override
        protected List<EventDay> doInBackground(Void... voids) {

            //First it gets all the data
            List<LogRecords> logRecords = databaseini.getDatabase().getDao().getAllLogs();
            List<EventDay> events = new ArrayList();

            //Then check each data one by one
            for (LogRecords logRecord : logRecords) {

                String[] splitter = getStringSplitter(logRecord.getDate());
                Calendar calendar = Calendar.getInstance();
                calendar.set(Integer.parseInt(splitter[2]), Integer.parseInt(splitter[1])-1, Integer.parseInt(splitter[0]));


                //Makes the color against the record data
                ColorDrawable colorDrawable = new ColorDrawable(logRecord.getColor());
                //Adds the color and the date to show the user
                events.add(new EventDay(calendar, colorDrawable));
                //materialCalendarView.setDateSelected(CalendarDay.from(calendar.get(Calendar.YEAR),
                // calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH)), true);
            }




            return events;
        }

        //This splits the date into individual data like 22-11-2019 to 22 11 2019
        private String[] getStringSplitter(String date) {
            return date.split("-");
        }


        //This will show dates to user
        @Override
        protected void onPostExecute(List<EventDay> events) {


            calendarView.setEvents(events);
        }
    }
}

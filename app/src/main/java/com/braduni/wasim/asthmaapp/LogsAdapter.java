package com.braduni.wasim.asthmaapp;


import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


//This is the adapter it tells the list which items to show ?
//How to show?
//and what to show?
public class LogsAdapter extends RecyclerView.Adapter<LogsAdapter.MyViewHolder> {


    List<LogRecords> list;



    public LogsAdapter() {
        list = new ArrayList<>();
    }



    //It creates the cell and show it to user
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_logs, parent, false));
    }



    //It attaches the data to each cell
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        LogRecords logRecord = list.get(position);
        holder.date.setText(logRecord.getDate());

        StringBuilder symptoms = new StringBuilder();
        //we get all the data from hashmap and convert it into a string and show it to user
        for (Map.Entry entry:logRecord.getMap().entrySet()
             ) {
            symptoms.append(String.valueOf(entry.getKey() + "\n")); // Question TODO: 19/03/2019
            symptoms.append(String.valueOf(entry.getValue() + "\n")); // Answer
            symptoms.append("\n");
        }

        holder.symptoms.setText(symptoms.toString());
    }

    //It tells how many items to show
    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<LogRecords> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    //Attaches each cell of the recyclerview and its compponents
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView date, symptoms;
        ImageView delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.item_date);
            symptoms = itemView.findViewById(R.id.item_symptoms);
            delete = itemView.findViewById(R.id.item_log_delete);


            //This method is triggers when a user clicks on delete button
            delete.setOnClickListener(v -> {

                new DeleteData().execute(list.get(getAdapterPosition()));
                list.remove(getAdapterPosition());


                //It tells the recylerview that the data is changed
                notifyDataSetChanged();
            });
        }
    }


    //Deletes data from database asynchronously
    public class DeleteData extends AsyncTask<LogRecords, Void, Void> {

        @Override
        protected Void doInBackground(LogRecords... logRecords) {

            databaseini.getDatabase().getDao().deleteData(logRecords[0]);
            return null;
        }




    }



}

package com.a20076520.skirmantas.warframecodex;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Warframelist extends AppCompatActivity{

    private static final String TAG = "Warframelist";

    DatabaseHelper wDatabaseHelpmer;

    private ListView  wListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_warframelayout);
        wListView = (ListView) findViewById(R.id.listViewFrames);
        wDatabaseHelpmer = new DatabaseHelper(this);

        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the listView.");
        Cursor data = wDatabaseHelpmer.getAllData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        wListView.setAdapter(adapter);
    }
}

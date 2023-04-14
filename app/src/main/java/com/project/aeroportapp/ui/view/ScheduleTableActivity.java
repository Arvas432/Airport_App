package com.project.aeroportapp.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.project.aeroportapp.R;

public class ScheduleTableActivity extends AppCompatActivity {
    private  String[] nameArr = new String[] { "У6-9153", "У6-9157","С7-5235","У6-9713","B2-8741","С7-5237" ,"С7-5237"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_table);

        listView = findViewById(R.id.list_view_schedule);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.schedule_table_list_item, R.id.text_view_flight, nameArr);
        listView.setAdapter(adapter);

    }
    public void closeAndGoScheduleTable(View v) {
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }
}
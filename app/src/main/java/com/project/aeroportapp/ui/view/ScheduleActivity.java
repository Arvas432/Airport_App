package com.project.aeroportapp.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.project.aeroportapp.R;

public class ScheduleActivity extends AppCompatActivity {

    private  String[] nameArr = new String[] { "Владивосток", "Магадан","Минеральные воды","Москва","Нерюнги","Николаевск-на-Амуре" ,"Новосибирск"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        listView = findViewById(R.id.list_view_schedule);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.schedule_list_item, R.id.schedule_list_item_text, nameArr);
        listView.setAdapter(adapter);
    }
    public void goHome(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
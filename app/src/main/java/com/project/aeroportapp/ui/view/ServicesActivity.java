package com.project.aeroportapp.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.project.aeroportapp.R;

public class ServicesActivity extends AppCompatActivity {

    private  String[] nameArr = new String[] { "Аптеки", "Кафе","Вендинговые аппараты","Магазины","Стойки авиакомпаний","Банкоматы" ,"Упаковка багажа", "Камеры хранения", "Капсульные отель"};
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        gridView = findViewById(R.id.grid_view_services);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.services_grid_list_item, R.id.service_list_item_text, nameArr);
        gridView.setAdapter(adapter);


//
    }
}
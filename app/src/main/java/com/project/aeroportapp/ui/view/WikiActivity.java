package com.project.aeroportapp.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.project.aeroportapp.R;

public class WikiActivity extends AppCompatActivity {

    private  String[] nameArr = new String[] { "Правила провоза багажа","Нормы бесплатного провоза багажа","Упаковка багажа","Хранение багажа","Получение багажа","Розыск багажа","Повреждение багажа","Сверхнормативный багаж","Негабаритный багаж","Животные и растения"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki);

        listView = findViewById(R.id.list_view_wiki);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.wiki_list_item, R.id.wiki_list_item_text, nameArr);
        listView.setAdapter(adapter);
    }
    public void goWikiTable(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
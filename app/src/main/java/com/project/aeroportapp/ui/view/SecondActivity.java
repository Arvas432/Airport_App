package com.project.aeroportapp.ui.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.aeroportapp.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
//    public void goBack(View v) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }
}
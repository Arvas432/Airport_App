package com.project.aeroportapp.ui.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.project.aeroportapp.R;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.repositories.FlightsRepository;
import com.project.aeroportapp.ui.adapters.CustomRecyclerViewAdapter;
import com.project.aeroportapp.ui.viewmodels.FlightTableViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MainActivity extends FragmentActivity implements NavHost {
    private int currentfragment = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavController nv = Navigation.findNavController(findViewById(R.id.fragment_flights));

        ImageButton table_button = findViewById(R.id.btn_menu_home);
        ImageButton schedule_button = findViewById(R.id.schedule_button);
        ImageButton services_button = findViewById(R.id.btn_menu_services);
        ImageButton wiki_button = findViewById(R.id.btn_menu_wiki);
        ImageButton more_button = findViewById(R.id.btn_menu_more);

        table_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentfragment){
                    case 1:
                        break;
                    case 2:
                        nv.navigate(R.id.action_scheduleFragment_to_flightFragment2);
                        break;
                    case 3:
                        nv.navigate(R.id.action_fragmentServices_to_flightFragment2);
                        break;
                    case 4:
                        nv.navigate(R.id.action_fragmentWiki_to_flightFragment2);
                        break;
                    case 5:
                        nv.navigate(R.id.action_mainMenuFragment_to_flightFragment);
                        break;
                }
                currentfragment = 1;
            }
        });
        schedule_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentfragment){
                    case 1:
                        nv.navigate(R.id.action_flightFragment_to_scheduleFragment);
                        break;
                    case 2:
                        break;
                    case 3:
                        nv.navigate(R.id.action_fragmentServices_to_scheduleFragment);
                        break;
                    case 4:
                        nv.navigate(R.id.action_fragmentWiki_to_scheduleFragment);
                        break;
                    case 5:
                        nv.navigate(R.id.action_mainMenuFragment_to_scheduleFragment);
                        break;
                }
                currentfragment = 2;
            }
        });
        services_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentfragment){
                    case 1:
                        nv.navigate(R.id.action_flightFragment_to_fragmentServices);
                        break;
                    case 2:
                        nv.navigate(R.id.action_scheduleFragment_to_fragmentServices);
                        break;
                    case 3:
                        break;
                    case 4:
                        nv.navigate(R.id.action_fragmentWiki_to_fragmentServices);
                        break;
                    case 5:
                        nv.navigate(R.id.action_mainMenuFragment_to_fragmentServices);
                        break;
                }
                currentfragment = 3;
            }
        });
        wiki_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentfragment){
                    case 1:
                        nv.navigate(R.id.action_flightFragment_to_fragmentWiki);
                        break;
                    case 2:
                        nv.navigate(R.id.action_scheduleFragment_to_fragmentWiki);
                        break;
                    case 3:
                        nv.navigate(R.id.action_fragmentServices_to_fragmentWiki4);
                    case 4:
                        break;
                    case 5:
                        nv.navigate(R.id.action_mainMenuFragment_to_fragmentWiki);
                        break;
                }
                currentfragment = 4;
            }
        });
        more_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentfragment){
                    case 1:
                        nv.navigate(R.id.action_flightFragment_to_mainMenuFragment);
                        break;
                    case 2:
                        nv.navigate(R.id.action_scheduleFragment_to_mainMenuFragment);
                        break;
                    case 3:
                        nv.navigate(R.id.action_fragmentServices_to_mainMenuFragment);
                    case 4:
                        nv.navigate(R.id.action_fragmentWiki_to_mainMenuFragment);
                        break;
                    case 5:
                        break;
                }
                currentfragment = 5;
            }
        });


    }

    @NonNull
    @Override
    public NavController getNavController() {
        return null;
    }

}
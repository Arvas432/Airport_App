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
        ImageButton reg_button = findViewById(R.id.btn_menu_reg);
        ImageButton services_button = findViewById(R.id.btn_menu_services);
        ImageButton wiki_button = findViewById(R.id.btn_menu_wiki);

        wiki_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentfragment){
                    case 1:
                        nv.navigate(R.id.action_flightFragment_to_fragmentWiki);
                        break;
                    case 2:
                        break;
                    case 3:
                        nv.navigate(R.id.action_fragmentServices_to_fragmentWiki4);
                    case 4:
                        break;
                }
                currentfragment = 4;
            }
        });
        table_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (currentfragment){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        nv.navigate(R.id.action_fragmentServices_to_flightFragment2);
                        break;
                    case 4:
                        nv.navigate(R.id.action_fragmentWiki_to_flightFragment2);
                        break;
                }
                currentfragment = 1;
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
                        break;
                    case 3:
                        break;
                    case 4:
                        nv.navigate(R.id.action_fragmentWiki_to_fragmentServices3);
                }
                currentfragment = 3;
            }
        });

//        NavController navController = Navigation.findNavController(this, R.id.bottombar_fragment);
//        NavController navController1 = Navigation.findNavController(this, R.id.fragment_flights);

//        RecyclerView rv = findViewById(R.id.recycler_view_tablo);
//        FlightTableViewModel flightTableViewModel = new FlightTableViewModel() ;
//        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(this, FlightsRepository.get(), this);
//        LinearLayoutManager lm = new LinearLayoutManager(this);
//        rv.setAdapter(adapter);
//        rv.setLayoutManager(lm);


//        btn_fragment_departure = findViewById(R.id.btn_fragment_internal);
//        btn_fragment_arrival = findViewById(R.id.btn_fragment_international);
//
//        setNewFragment(firstFragment);
//
//        btn_fragment_departure .setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                SecondFragment secondFragment = new SecondFragment();
//                setNewFragment(firstFragment);
//            }
//        });
//
//        btn_fragment_arrival.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                SecondFragment secondFragment = new SecondFragment();
//                setNewFragment(secondFragment);
//            }
//        });

    }

    @NonNull
    @Override
    public NavController getNavController() {
        return null;
    }
//    private void setNewFragment(Fragment fragment) {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.frame_layout, fragment);
//        ft.addToBackStack(null);
//        ft.commit();
//    }


//    public void goSchedule(View view) {
//        Intent intent = new Intent(this, ScheduleActivity.class);
//        startActivity(intent);
//    }
//    public void goServices(View view) {
//        Intent intent = new Intent(this, ServicesActivity.class);
//        startActivity(intent);
//    }
//    public void goWiki(View view) {
//        Intent intent = new Intent(this, WikiActivity.class);
//        startActivity(intent);
//    }
//    public void goMainMenu(View view) {
//        Intent intent = new Intent(this, MainMenuCustomActivity.class);
//        startActivity(intent);
//    }
//    public void startNewActivity(View v) {
//        Intent intent = new Intent(this, SecondActivity.class);
//        startActivity(intent);
//    }
}
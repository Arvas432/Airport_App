package com.project.aeroportapp.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.project.aeroportapp.R;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.repositories.FlightsRepository;
import com.project.aeroportapp.ui.adapters.CustomRecyclerViewAdapter;
import com.project.aeroportapp.ui.viewmodels.FlightTableViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
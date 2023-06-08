package com.project.aeroportapp.ui.view;

import android.Manifest;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import com.google.gson.Gson;
import com.project.aeroportapp.R;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.repositories.FlightsRepository;
import com.project.aeroportapp.ui.adapters.CustomRecyclerViewAdapter;
import com.project.aeroportapp.ui.adapters.DatabaseListAdapter;
import com.project.aeroportapp.ui.viewmodels.DatabaseViewModel;
import com.project.aeroportapp.ui.viewmodels.FlightTableViewModel;
import com.project.aeroportapp.ui.viewmodels.StorageViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FlightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FlightFragment extends Fragment implements NavHost {

    private View rootView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Flight flight;
    private DatabaseViewModel dvm;
    private StorageViewModel svm;

    public FlightFragment() {
        // Required empty public constructor
    }

    private final ActivityResultLauncher<String> requestSavePermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.CreateDocument("txt/*"), uri -> {
                if (uri != null) {
                    try {
                        ParcelFileDescriptor txt = getActivity().getContentResolver().openFileDescriptor(uri, "w");
                        FileOutputStream fileOutputStream = new FileOutputStream(txt.getFileDescriptor());
                        fileOutputStream.write(flight.getFlightCode().getBytes());
                        fileOutputStream.close();
                        txt.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            });
    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {

                }
            });


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FlightFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FlightFragment newInstance(String param1, String param2) {
        FlightFragment fragment = new FlightFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_flight, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FlightTableViewModel flightTableViewModel = new FlightTableViewModel();
        svm = new StorageViewModel(this.getActivity().getApplication());
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        RecyclerView rv = rootView.findViewById(R.id.recycler_view_tablo);
        DatabaseViewModel databaseViewModel = new DatabaseViewModel(this.getActivity().getApplication());
        DatabaseListAdapter adapter = new DatabaseListAdapter(this.getContext(), databaseViewModel, this);
        LinearLayoutManager lm = new LinearLayoutManager(this.getContext());
        rv.setAdapter(adapter);
        rv.setLayoutManager(lm);
        TextView date = rootView.findViewById(R.id.Date_textview);
        date.setText("Сегодня: " + currentDate);
        Button saveButton = rootView.findViewById(R.id.buttonSave);
        saveButton.setOnClickListener((sv) -> {
            flight = flightTableViewModel.getFlights().get(adapter.getSelectedPos());
            String filename = "посадочный_талон_рейс_" + flight.getFlightCode() + ".txt" ;
            svm.writeToFile(flight.getFlightCode() + " " + flight.getAirline());
            //svm.saveSharedPref();
            requestSavePermissionLauncher.launch(filename);

        });

    }
    @NonNull
    @Override
    public NavController getNavController() {
        return null;
    }
}
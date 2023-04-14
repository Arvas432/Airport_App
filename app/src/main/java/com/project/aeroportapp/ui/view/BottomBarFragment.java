package com.project.aeroportapp.ui.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.project.aeroportapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottomBarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomBarFragment extends Fragment implements NavHost {

    private View rootView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BottomBarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottomBarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BottomBarFragment newInstance(String param1, String param2) {
        BottomBarFragment fragment = new BottomBarFragment();
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
        rootView = inflater.inflate(R.layout.fragment_bottom_bar, container, false);
        Log.e("TAg","view inflated");
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageButton table_button = rootView.findViewById(R.id.btn_menu_home);
        ImageButton reg_button = rootView.findViewById(R.id.btn_menu_reg);
        ImageButton services_button = rootView.findViewById(R.id.btn_menu_services);
        ImageButton wiki_button = rootView.findViewById(R.id.btn_menu_wiki);
        services_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navigation.findNavController(rootView).navigate(R.id.action_bottomBarFragment_to_fragmentServices);
            }
        });
    }

    @NonNull
    @Override
    public NavController getNavController() {
        return null;
    }
}
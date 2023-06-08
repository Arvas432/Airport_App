package com.project.aeroportapp.ui.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.aeroportapp.R;
import com.project.aeroportapp.ui.adapters.ServicesList_adapter;
import com.project.aeroportapp.ui.viewmodels.ServiceViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentWiki#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentWiki extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private View rootview;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentWiki() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentWiki.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentWiki newInstance(String param1, String param2) {
        FragmentWiki fragment = new FragmentWiki();
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
        rootview = inflater.inflate(R.layout.fragment_wiki, container, false);
        return rootview;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView rv = rootview.findViewById(R.id.list_view_wiki);
        ServiceViewModel vm = new ServiceViewModel();
        ServicesList_adapter sad = new ServicesList_adapter(this.getContext(), vm, this);
        LinearLayoutManager lm = new LinearLayoutManager(this.getContext());
        rv.setAdapter(sad);
        rv.setLayoutManager(lm);
        super.onViewCreated(view, savedInstanceState);
    }
}
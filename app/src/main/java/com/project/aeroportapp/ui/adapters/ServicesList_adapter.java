package com.project.aeroportapp.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.project.aeroportapp.R;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.model.Service;
import com.project.aeroportapp.ui.viewmodels.FlightTableViewModel;
import com.project.aeroportapp.ui.viewmodels.ServiceViewModel;

import java.util.List;

public class ServicesList_adapter extends RecyclerView.Adapter<ServicesList_adapter.ViewHolder>{
    private final LayoutInflater inflater;
    private List<Service> items;

    private ServiceViewModel serviceViewModel;
    public ServicesList_adapter(Context context, ServiceViewModel serviceViewModel, Fragment fragment) {

        this.serviceViewModel = serviceViewModel;
        this.items =  serviceViewModel.getServices();
        this.inflater = LayoutInflater.from(context);
        serviceViewModel.getServiceData()
                .observe(fragment.getViewLifecycleOwner(),(getFlightsInfo) -> {
                    this.notifyDataSetChanged();
                });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.service_grid_item, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Service item = items.get(position);
        holder.Itemname.setText(item.getName());
    }

    @Override
    public int getItemCount() {

        if(items==null) return 0;
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView Itemname;


        ViewHolder(View view){
            super(view);
            Itemname = view.findViewById(R.id.grid_item_name);


        }
    }
}

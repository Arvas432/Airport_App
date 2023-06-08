package com.project.aeroportapp.ui.adapters;

import android.content.Context;
import android.graphics.Color;
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
import com.project.aeroportapp.data.entities.FlightEntity;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.ui.viewmodels.DatabaseViewModel;
import com.project.aeroportapp.ui.viewmodels.FlightTableViewModel;

import java.util.List;

public class DatabaseListAdapter extends RecyclerView.Adapter<DatabaseListAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private List<Flight> items;
    private int selectedPos = RecyclerView.NO_POSITION;
    private DatabaseViewModel flightTableViewModel;
    public DatabaseListAdapter(Context context, DatabaseViewModel flightTableViewModel_, Fragment fragment)
    {
        this.items =  flightTableViewModel_.getFlights();
        this.inflater = LayoutInflater.from(context);
        this.flightTableViewModel = flightTableViewModel_;
        flightTableViewModel_.getflightdata()
                .observe(fragment.getViewLifecycleOwner(),(getFlightsInfo) -> {
                    this.items = getFlightsInfo;
                    this.notifyDataSetChanged();
                });

    }
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.tablo_table_list_item, parent, false);
        return new ViewHolder(view);
    }

    public int getSelectedPos() {
        return selectedPos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView Itemcity;
        private TextView Itemtime;
        private TextView ItemflightCode;
        private TextView ItemregistrationFinished;
        private TextView Itemairline;
        private TextView Itemgate;

        ViewHolder(View view){
            super(view);
            Itemcity = view.findViewById(R.id.table_text_view_city);
            Itemtime = view.findViewById(R.id.tablo_table_text_view_time);
            ItemflightCode = view.findViewById(R.id.tablo_table_text_view_flight);
            ItemregistrationFinished = view.findViewById(R.id.tablo_table_text_view_period);
            Itemairline = view.findViewById(R.id.tablo_table_text_view_days);
            Itemgate = view.findViewById(R.id.text_view_gate);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        }
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Flight item = items.get(position);
        holder.itemView.setSelected(selectedPos == position);
        holder.Itemtime.setText(item.getTime());
        holder.Itemairline.setText(item.getAirline());
        holder.itemView.setBackgroundColor(selectedPos == position ? Color.rgb(228, 236, 247): Color.TRANSPARENT);
        if(item.getRegistrationFinished())
        {
            holder.ItemregistrationFinished.setText("Регистрация окончена");
        }
        else
        {
            holder.ItemregistrationFinished.setText("Регистрация идет");
        }
        holder.ItemflightCode.setText(item.getFlightCode());
        holder.Itemcity.setText(item.getCity());
        holder.Itemgate.setText("Выход - " +item.getGate());
        holder.itemView.setOnClickListener((layout) -> {
            if(position == RecyclerView.NO_POSITION) return;
            Log.i("TAG", "Element " + position + " clicked");
            notifyItemChanged(selectedPos);
            selectedPos = holder.getAdapterPosition();
            notifyItemChanged(selectedPos);


            //Toast.makeText(inflater.getContext(), "Element " + position + " clicked", Toast.LENGTH_SHORT).show();
        });
    }
    @Override
    public int getItemCount() {
        if(items==null) return 0;
        return items.size();
    }


}
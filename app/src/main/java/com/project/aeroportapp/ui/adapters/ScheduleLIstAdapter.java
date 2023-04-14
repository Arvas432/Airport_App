package com.project.aeroportapp.ui.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.project.aeroportapp.R;
import com.project.aeroportapp.data.model.Flight;
import com.project.aeroportapp.data.model.ScheduleItem;
import com.project.aeroportapp.ui.viewmodels.FlightTableViewModel;
import com.project.aeroportapp.ui.viewmodels.ScheduleViewModel;

import java.util.List;

public class ScheduleLIstAdapter extends RecyclerView.Adapter<ScheduleLIstAdapter.ViewHolder>{
    private List<ScheduleItem> items;
    private final LayoutInflater inflater;
    private ScheduleViewModel viewModel;

    public ScheduleLIstAdapter(Context context, ScheduleViewModel ScheduleViewModel_, Fragment fragment){
        this.items = ScheduleViewModel_.getScheduleItems();
        this.inflater = LayoutInflater.from(context);
        this.viewModel = ScheduleViewModel_;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.schedule_table_list_item, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ScheduleItem item = items.get(position);
        holder.flightNumber.setText(item.getFlightnumber());
        holder.dayOfTheWeek.setText("Вт");
        holder.timePeriod.setText(item.getDate());
        holder.time.setText(item.getTime());
        holder.airlineName.setText(item.getAirline());
        holder.airlineLogo.setImageResource(R.drawable.utair);
        holder.itemView.setOnClickListener((layout) -> {
            Log.i("TAG", "Element " + position + " clicked");
            Toast.makeText(inflater.getContext(), "Element " + position + " clicked", Toast.LENGTH_SHORT).show();
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends
            RecyclerView.ViewHolder {
        private ImageView airlineLogo;
        private TextView airlineName;
        private TextView timePeriod;
        private TextView time;
        private TextView dayOfTheWeek;
        private TextView flightNumber;

        ViewHolder(View view){
            super(view);
            airlineLogo = view.findViewById(R.id.airline_logo);
            airlineName = view.findViewById(R.id.text_view_avia);
            timePeriod = view.findViewById(R.id.textViewPeriod);
            time = view.findViewById(R.id.textViewTime);
            dayOfTheWeek = view.findViewById(R.id.textViewDays);
            flightNumber = view.findViewById(R.id.text_view_flight_number);

        } }
}

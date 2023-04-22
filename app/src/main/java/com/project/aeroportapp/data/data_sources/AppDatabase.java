package com.project.aeroportapp.data.data_sources;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.project.aeroportapp.data.entities.FlightEntity;
import com.project.aeroportapp.data.model.Flight;

@Database(entities = {FlightEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FlightDAO flightDAO();
    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static RoomDatabase.Callback DBPopulationCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                FlightDAO dao = INSTANCE.flightDAO();;
                dao.deleteAll();
                ArrayList<FlightEntity> flights = new ArrayList<FlightEntity>(){
                    {
                        add(new FlightEntity("Владивосток", "21:30", "АF412", false, "Аэрофлот", "B4"));
                        add(new FlightEntity("Токио", "22:10","UT412",false,"UTAIR","G1"));
                        add(new FlightEntity("Лондон", "22:45","RA315",true,"RyanAir","A5"));
                        add(new FlightEntity("Анталия", "23:20","TA513",false,"Turkish Airlines","B1"));
                        add(new FlightEntity("Рязань", "0:10","AF122",false,"Аэрофлот","D2"));
                        add(new FlightEntity("Екатеринбург", "0:45","UR512",false,"Ural Airlines","F5"));
                        add(new FlightEntity("Алматы", "1:15","AA433",false,"Air Astana","G1"));
                    }

                };
                ArrayList<Long> partIds = new ArrayList<Long>();
                for (FlightEntity fe : flights)
                {
                    long id = dao.insertPart(fe);
                    partIds.add(id);
                }
            });
        }
    };

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "flightsTable")
                            .fallbackToDestructiveMigration()
                            .addCallback(DBPopulationCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}


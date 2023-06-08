package com.project.aeroportapp.data.data_sources;

import static androidx.activity.result.ActivityResultCallerKt.registerForActivityResult;

import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import com.project.aeroportapp.R;
import com.project.aeroportapp.data.repositories.FlightsDatabaseRepos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class StorageDataSource {
    private FlightsDatabaseRepos repos;
    private SharedPreferences sharedPref;
    private File file;
    private  FileInputStream fis;

    public StorageDataSource(Application app)
    {
        repos = new FlightsDatabaseRepos(app);
        file = new File(app.getFilesDir() ,"savedata.txt");
        sharedPref  = app.getSharedPreferences( "",Context.MODE_PRIVATE);
        try
        {
            fis = app.getApplicationContext().openFileInput("savedata.txt");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public void writeTo(String data)
    {
        try {

            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file, true);
            fos.write(data.getBytes());
            fos.close();

            byte[] buffer = new byte[1024];
            while (fis.read(buffer) != -1) {
                Log.i("content", new String(buffer, StandardCharsets.UTF_8));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void WriteToSharedPref()
    {

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("date_key", new Date().toString());
        editor.apply();
        String currdate = sharedPref.getString("date_key","");
        Log.i("sharedpref", currdate);
    }


}

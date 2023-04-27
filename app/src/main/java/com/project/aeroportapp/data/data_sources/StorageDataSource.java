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
    private Application app;
    private String WriteData;
    private FlightsDatabaseRepos repos;

    public StorageDataSource(Application app)
    {
        this.app = app;
        repos = new FlightsDatabaseRepos(app);
    }
//    private final ActivityResultLauncher<String> requestSavePermissionLauncher =
//            f.registerForActivityResult(new ActivityResultContracts.CreateDocument("txt/*"), uri -> {
//                if (uri != null) {
//                    try {
//
//                        ParcelFileDescriptor txt = app.getApplicationContext().getContentResolver().openFileDescriptor(uri, "w");
//                        FileOutputStream fileOutputStream = new FileOutputStream(txt.getFileDescriptor());
//                        fileOutputStream.write((WriteData).getBytes());
//                        fileOutputStream.close();
//                        txt.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });

    public void writeTo(String data)
    {

        String filename = "savedata.txt";
        try {
//            File file = Environment.getExternalStoragePublicDirectory(
//                    Environment.DIRECTORY_DOWNLOADS);
//          //  File file = new File(app.getApplicationContext().getFilesDir(), filename);
//            file.createNewFile();
//            FileOutputStream fos = new FileOutputStream(file, true);
//            fos.write(data.getBytes());
//            fos.close();
//            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
//            writer.write(data);
//            writer.close();
//            File myFile = new File("/sdcard/mysdfile.txt");
//            myFile.createNewFile();
//            FileOutputStream fOut = new FileOutputStream(myFile);
//            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
//            myOutWriter.append(data);
//            myOutWriter.close();
//            fOut.close();

            FileInputStream fis = app.getApplicationContext().openFileInput(filename);
            byte[] buffer = new byte[1024];
            while (fis.read(buffer) != -1) {
                Log.i("content", new String(buffer, StandardCharsets.UTF_8));
            }
            SharedPreferences sharedPref = app.getSharedPreferences( "",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString( app.getString(R.string.currentdatekey), new Date().toString());
            editor.apply();
            String currdate = sharedPref.getString(app.getString(R.string.currentdatekey),"");
            Log.i("sharedpref", currdate);
//            ParcelFileDescriptor txt = app.getApplicationContext().getContentResolver().openFileDescriptor(, "w");
//            FileOutputStream fileOutputStream = new FileOutputStream(txt.getFileDescriptor());
//            fileOutputStream.write((WriteData).getBytes());
//            fileOutputStream.close();
//            txt.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

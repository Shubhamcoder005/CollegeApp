package com.example.collegeapp;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class about extends AppCompatActivity {

    TextView version;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Objects.requireNonNull(getSupportActionBar()).setTitle("About");

        version=findViewById(R.id.version);

        PackageManager manager=this.getPackageManager();
        try {
            PackageInfo info=manager.getPackageInfo(this.getPackageName(),PackageManager.GET_ACTIVITIES);
            version.setText("Version"+info.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
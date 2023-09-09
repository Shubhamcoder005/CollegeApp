package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Daily_Task_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_task);

        getSupportActionBar().setTitle("Daily Task");
    }
}
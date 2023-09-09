package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Attendance_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        getSupportActionBar().setTitle("Attendance System");
    }
}
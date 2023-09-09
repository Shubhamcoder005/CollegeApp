package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Subjects_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        getSupportActionBar().setTitle("Subjects");
    }
}
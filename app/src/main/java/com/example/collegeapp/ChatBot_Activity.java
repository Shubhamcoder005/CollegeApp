package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ChatBot_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        getSupportActionBar().setTitle("Chat Bot");
    }
}
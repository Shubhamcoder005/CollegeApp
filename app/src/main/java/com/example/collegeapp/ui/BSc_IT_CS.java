package com.example.collegeapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.collegeapp.R;

public class BSc_IT_CS extends AppCompatActivity {

    CardView bsc_it,bsc_cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsc_it_cs);

        bsc_it=findViewById(R.id.bsc_it);
        bsc_cs=findViewById(R.id.bsc_cs);

        getSupportActionBar().setTitle("Course");

        bsc_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BSc_IT_CS.this, Semester_Activity.class);
                startActivity(intent);
            }
        });

        bsc_cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BSc_IT_CS.this, Semester_Activity.class);
                startActivity(intent);
            }
        });

    }
}
package com.example.collegeapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.collegeapp.R;

import java.util.Objects;

public class Semester_Activity extends AppCompatActivity {

    CardView sem1,sem2,sem3,sem4,sem5,sem6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Semesters");

        sem1=findViewById(R.id.sem1);
        sem2=findViewById(R.id.sem2);
        sem3=findViewById(R.id.sem3);
        sem4=findViewById(R.id.sem4);
        sem5=findViewById(R.id.sem5);
        sem6=findViewById(R.id.sem6);

        sem1.setOnClickListener(v -> {

            Intent next=new Intent(Semester_Activity.this, Subjects_Activity.class);
            startActivity(next);

        });

        sem2.setOnClickListener(v -> {

            Intent next=new Intent(Semester_Activity.this, Subjects_Activity.class);
            startActivity(next);

        });

        sem3.setOnClickListener(v -> {

            Intent next=new Intent(Semester_Activity.this, Subjects_Activity.class);
            startActivity(next);

        });

        sem4.setOnClickListener(v -> {

            Intent next=new Intent(Semester_Activity.this, Subjects_Activity.class);
            startActivity(next);

        });

        sem5.setOnClickListener(v -> {

            Intent next=new Intent(Semester_Activity.this, Subjects_Activity.class);
            startActivity(next);

        });

        sem6.setOnClickListener(v -> {

            Intent next=new Intent(Semester_Activity.this, Subjects_Activity.class);
            startActivity(next);

        });

    }


}
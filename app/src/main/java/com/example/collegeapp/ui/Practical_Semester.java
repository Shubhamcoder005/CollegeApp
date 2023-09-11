package com.example.collegeapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.collegeapp.R;

import java.util.Objects;

public class Practical_Semester extends AppCompatActivity {

    CardView Practical_sem1,Practical_sem2,Practical_sem3,Practical_sem4,Practical_sem5,Practical_sem6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_semester);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Semesters");

        Practical_sem1=findViewById(R.id.Practical_sem1);
        Practical_sem2=findViewById(R.id.Practical_sem2);
        Practical_sem3=findViewById(R.id.Practical_sem3);
        Practical_sem4=findViewById(R.id.Practical_sem4);
        Practical_sem5=findViewById(R.id.Practical_sem5);
        Practical_sem6=findViewById(R.id.Practical_sem6);

        Practical_sem1.setOnClickListener(v -> {

            Intent next=new Intent(Practical_Semester.this, PracticalSubjectActivity.class);
            startActivity(next);

        });

        Practical_sem2.setOnClickListener(v -> {

            Intent next=new Intent(Practical_Semester.this, PracticalSubjectActivity.class);
            startActivity(next);

        });

        Practical_sem3.setOnClickListener(v -> {

            Intent next=new Intent(Practical_Semester.this, PracticalSubjectActivity.class);
            startActivity(next);

        });

        Practical_sem4.setOnClickListener(v -> {

            Intent next=new Intent(Practical_Semester.this, PracticalSubjectActivity.class);
            startActivity(next);

        });

        Practical_sem5.setOnClickListener(v -> {

            Intent next=new Intent(Practical_Semester.this, PracticalSubjectActivity.class);
            startActivity(next);

        });

        Practical_sem6.setOnClickListener(v -> {

            Intent next=new Intent(Practical_Semester.this, PracticalSubjectActivity.class);
            startActivity(next);

        });
    }
}
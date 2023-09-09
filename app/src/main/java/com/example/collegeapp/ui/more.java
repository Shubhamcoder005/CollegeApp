package com.example.collegeapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.collegeapp.R;
import com.example.collegeapp.Terms_and_condition;
import com.example.collegeapp.safety_tips;
import com.google.android.material.navigation.NavigationView;

public class more extends AppCompatActivity {

    NavigationView menuNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        getSupportActionBar().setTitle("More");


        menuNavigation=findViewById(R.id.menuNavigation);

        menuNavigation.setNavigationItemSelectedListener(menuItem -> {

            int id = menuItem.getItemId();
            if (id == R.id.safety_tips) {

                Intent next=new Intent(more.this, safety_tips.class);
                startActivity(next);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            } else if (id == R.id.terms) {

                Intent next=new Intent(more.this, Terms_and_condition.class);
                startActivity(next);

            } else if (id == R.id.privacy) {

                Intent next=new Intent(more.this, pravacy_policy.class);
                startActivity(next);

            } else if (id == R.id.about) {

                Intent next=new Intent(more.this, about.class);
                startActivity(next);

            } else {

                Intent next=new Intent(more.this,logout.class);
                startActivity(next);
            }

            return true;
        });


 }
}
package com.example.collegeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigation;
    Toolbar toolbar;

    BottomNavigationView bottom_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bottom navigation
        bottom_home=findViewById(R.id.bottom_home);

        //toolbar open and close
        drawerLayout=findViewById(R.id.drawerlayout);
        navigation=findViewById(R.id.navigation);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();



        bottom_home.setOnNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id==R.id.home){

                      loadbuttonfragment(new Home(),false);

                } else if (id==R.id.download) {

                   loadbuttonfragment(new profile(),false);

                } else if (id==R.id.notification) {

                    loadbuttonfragment(new Quiz_game(),false);

                } else if (id==R.id.game) {

                      loadbuttonfragment(new Quiz_game(),false);

                }else {

                      loadbuttonfragment(new profile(),false);

                }

                return true;
            }
        });

        bottom_home.setSelectedItemId(R.id.home);


        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int  num = item.getItemId();

                if (num==R.id.about){
                    Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
                } else if (num==R.id.theme) {
                    Toast.makeText(MainActivity.this, "Theme", Toast.LENGTH_SHORT).show();

                } else if (num==R.id.event) {
                    Toast.makeText(MainActivity.this, "Event`", Toast.LENGTH_SHORT).show();


                } else if (num==R.id.suggestion) {



                } else if (num==R.id.help_center) {



                } else if (num==R.id.report) {



                } else{


                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public void onBackPressed(){

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    private void loaddrawernavfragment(Fragment fragment,boolean flag){
        FragmentManager mm=getSupportFragmentManager();
        FragmentTransaction tt=mm.beginTransaction();
        if(flag) {
            tt.add(R.id.drawerlayout, fragment);
        }else {
            tt.replace(R.id.drawerlayout,fragment);
            tt.commit();
        }
    }


    //bottom navigation
    public void loadbuttonfragment(Fragment fragment,boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag) {
            ft.add(R.id.constraint, fragment);
        }else {
            ft.replace(R.id.constraint,fragment);
            ft.commit();
        }
    }
}
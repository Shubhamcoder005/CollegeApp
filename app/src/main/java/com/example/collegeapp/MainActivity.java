package com.example.collegeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigation,menuNavigation;
    Toolbar toolbar;

    BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bottom navigation
        bottomNavigationView=findViewById(R.id.bottomNavigationView);

        //toolbar open and close
        drawerLayout=findViewById(R.id.drawerlayout);
        navigation=findViewById(R.id.navigation);
        menuNavigation=findViewById(R.id.menuNavigation);
        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();


        navigation.setNavigationItemSelectedListener(menuItem -> {

            int id=menuItem.getItemId();
            if (id==R.id.about_faculty){

                loadbuttonfragment(new about_faclity(),false);
                bottomNavigationView.setVisibility(View.GONE);

            } else if (id==R.id.theme) {

                loadbuttonfragment(new theme(),false);
                bottomNavigationView.setVisibility(View.GONE);

            } else if (id==R.id.event) {

                loadbuttonfragment(new event(),false);
                bottomNavigationView.setVisibility(View.GONE);

            } else if (id==R.id.suggestion) {

                loadbuttonfragment(new suggestion(),false);
                bottomNavigationView.setVisibility(View.GONE);

            }else if(id==R.id.help_center){

                loadbuttonfragment(new help_center(),false);
                bottomNavigationView.setVisibility(View.GONE);

            }else if(id==R.id.report){

                loadbuttonfragment(new report(),false);
                bottomNavigationView.setVisibility(View.GONE);

            }else if(id==R.id.more){

                Intent next=new Intent(MainActivity.this, more.class);
                startActivity(next);

            }
            return true;
        });



        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

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
        });

        bottomNavigationView.setSelectedItemId(R.id.home);



    }



    //------------------------------------------------------------------------------------//

    @Override
    public void onBackPressed(){

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }

    //    bottom navigation
    public void loadbuttonfragment(Fragment fragment,boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(flag) {
            ft.add(R.id.constraint, fragment);
        }else {
            ft.replace(R.id.constraint,fragment);
            ft.commit();
        }

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

}
package com.example.collegeapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.collegeapp.fragments.Fragment_Download;
import com.example.collegeapp.fragments.Fragment_Notification;
import com.example.collegeapp.Home;
import com.example.collegeapp.Quiz_game;
import com.example.collegeapp.R;
import com.example.collegeapp.Report_a_Complaint;
import com.example.collegeapp.Suggestion;
import com.example.collegeapp.Theme;
import com.example.collegeapp.profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigation,menuNavigation;
    Toolbar toolbar;

    BottomNavigationView bottomNavigationView;

    CardView card_ebooks,card_chat_bot,card_practicals,card_notes,card_attendance,card_daily_task;



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

        card_ebooks=findViewById(R.id.card_ebooks);
        card_chat_bot=findViewById(R.id.card_chat_bot);
        card_practicals=findViewById(R.id.card_practicals);
        card_notes=findViewById(R.id.card_notes);
        card_attendance=findViewById(R.id.card_attendance);
        card_daily_task=findViewById(R.id.card_daily_task);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();


        navigation.setNavigationItemSelectedListener(menuItem -> {

            int id=menuItem.getItemId();
            if (id==R.id.about_faculty){

                Intent next=new Intent(MainActivity.this, About_faclity.class);
                startActivity(next);

            } else if (id==R.id.theme) {

                Intent next=new Intent(MainActivity.this, Theme.class);
                startActivity(next);

            } else if (id==R.id.event) {

                Intent next=new Intent(MainActivity.this, Event.class);
                startActivity(next);

            } else if (id==R.id.suggestion) {

                Intent next=new Intent(MainActivity.this, Suggestion.class);
                startActivity(next);

            }else if(id==R.id.help_center){

                Intent next=new Intent(MainActivity.this, Help_Center.class);
                startActivity(next);

            }else if(id==R.id.report){

                Intent next=new Intent(MainActivity.this, Report_a_Complaint.class);
                startActivity(next);

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
                  getSupportActionBar().setTitle("Collage App");

            } else if (id==R.id.download) {

               loadbuttonfragment(new Fragment_Download(),false);
                getSupportActionBar().setTitle("Download");

            } else if (id==R.id.notification) {

                loadbuttonfragment(new Fragment_Notification(),false);
                getSupportActionBar().setTitle("Notification");

            } else if (id==R.id.game) {

                  loadbuttonfragment(new Quiz_game(),false);
                  getSupportActionBar().setTitle("Quiz Game");

            }else {

                  loadbuttonfragment(new profile(),false);
                  getSupportActionBar().setTitle("My Profile");

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
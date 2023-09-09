package com.example.collegeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class Home extends Fragment {

    CardView card_ebooks,card_attendance,card_practicals,card_notes,card_chat_bot,card_daily_task;
    public Home() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        card_ebooks=view.findViewById(R.id.card_ebooks);
        card_attendance=view.findViewById(R.id.card_attendance);
        card_practicals=view.findViewById(R.id.card_practicals);
        card_notes=view.findViewById(R.id.card_notes);
        card_chat_bot=view.findViewById(R.id.card_chat_bot);
        card_daily_task=view.findViewById(R.id.card_daily_task);

        card_ebooks.setOnClickListener(v -> {

            Intent intent=new Intent(Objects.requireNonNull(getActivity()).getApplication(), BSc_IT_CS.class);
            startActivity(intent);
        });

        card_attendance.setOnClickListener(v -> {

            Intent intent=new Intent(Objects.requireNonNull(getActivity()).getApplication(), Attendance_Activity.class);
            startActivity(intent);
        });

        card_practicals.setOnClickListener(v -> {

            Intent intent=new Intent(Objects.requireNonNull(getActivity()).getApplication(), Practical_Course.class);
            startActivity(intent);
        });

        card_notes.setOnClickListener(v -> {

            Intent intent=new Intent(Objects.requireNonNull(getActivity()).getApplication(), Notice_Activity.class);
            startActivity(intent);
        });

        card_chat_bot.setOnClickListener(v -> {

            Intent intent=new Intent(Objects.requireNonNull(getActivity()).getApplication(), ChatBot_Activity.class);
            startActivity(intent);
        });

        card_daily_task.setOnClickListener(v -> {

            Intent intent=new Intent(Objects.requireNonNull(getActivity()).getApplication(), Daily_Task_Activity.class);
            startActivity(intent);
        });

        return view;
    }



}
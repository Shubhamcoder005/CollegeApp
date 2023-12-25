package com.example.collegeapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.collegeapp.ui.StartQuizActivity;


public class Quiz_game extends Fragment {

    CardView javaQuiz, pythonQuiz, cCppQuiz, mathQuiz;

    public Quiz_game() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_quiz_game, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        javaQuiz = view.findViewById(R.id.javaQuiz);
        pythonQuiz = view.findViewById(R.id.pythonQuiz);
        cCppQuiz = view.findViewById(R.id.cCppQuiz);
        mathQuiz = view.findViewById(R.id.mathQuiz);

        javaQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send to the start quiz activity to start the quiz game
                Intent intent = new Intent(requireActivity(), StartQuizActivity.class);
                intent.putExtra("subject","Java");
                startActivity(intent);
            }
        });

        pythonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send to the start quiz activity to start the quiz game
                Intent intent = new Intent(requireActivity(), StartQuizActivity.class);
                intent.putExtra("subject","Python");
                startActivity(intent);
            }
        });

        cCppQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send to the start quiz activity to start the quiz game
                Intent intent = new Intent(requireActivity(), StartQuizActivity.class);
                intent.putExtra("subject","C/C++");
                startActivity(intent);
            }
        });


        mathQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send to the start quiz activity to start the quiz game
                Intent intent = new Intent(requireActivity(), StartQuizActivity.class);
                intent.putExtra("subject","Math");
                startActivity(intent);
            }
        });
    }
}
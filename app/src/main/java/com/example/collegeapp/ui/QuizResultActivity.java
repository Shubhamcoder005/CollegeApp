package com.example.collegeapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.collegeapp.R;

public class QuizResultActivity extends AppCompatActivity {

    TextView quizScore, quizTimeTaken, quizTotalQues, quizCorrectAnswer, quizWrongAnswer;
    Button quizExitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        quizScore = findViewById(R.id.quizScore);
        quizTimeTaken = findViewById(R.id.quizTimeTaken);
        quizTotalQues = findViewById(R.id.quizTotalQues);
        quizCorrectAnswer = findViewById(R.id.quizCorrectAnswer);
        quizWrongAnswer = findViewById(R.id.quizWrongAnswer);
        quizExitBtn = findViewById(R.id.quizExitBtn);

        quizScore.setText(getIntent().getIntExtra("correctAnswers",0)+"");
        quizTimeTaken.setText(getIntent().getStringExtra("quizTimeTaken"));
        quizTotalQues.setText("5");
        quizCorrectAnswer.setText(getIntent().getIntExtra("correctAnswers",0)+"\nCorrect");
        quizWrongAnswer.setText(getIntent().getIntExtra("wrongAnswers",0)+"\nWrong");
        quizExitBtn.setOnClickListener(v ->{
            finish();
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}
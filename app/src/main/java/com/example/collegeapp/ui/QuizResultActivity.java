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

        SharedPreferences sharedPreferences = getSharedPreferences("CollageApp",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        quizScore.setText(getIntent().getIntExtra("correctAnswers",0)+"");
        quizTimeTaken.setText(getIntent().getStringExtra("quizTimeTaken"));
        quizTotalQues.setText("5");
        quizCorrectAnswer.setText(getIntent().getIntExtra("correctAnswers",0)+"\nCorrect");
        quizWrongAnswer.setText(getIntent().getIntExtra("wrongAnswers",0)+"\nWrong");
        //set quiz time taken is 0
        editor.putString("quizTime","");
        editor.apply();
        quizExitBtn.setOnClickListener(v ->{
            finish();
            startActivity(new Intent(this, MainActivity.class));
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }
}
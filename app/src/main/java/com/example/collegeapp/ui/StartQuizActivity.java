package com.example.collegeapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collegeapp.R;

public class StartQuizActivity extends AppCompatActivity {

    ImageView backToQuiz;
    TextView quizSubject;
    Button quizStartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        backToQuiz = findViewById(R.id.backToQuiz);
        quizSubject = findViewById(R.id.quizSubject);
        quizStartBtn = findViewById(R.id.quizStartBtn);

        backToQuiz.setOnClickListener(v -> finish());

        //get the name of the subject from previous activity and set the this one
        quizSubject.setText(getIntent().getStringExtra("subject"));

        //start the quiz
        quizStartBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this,QuizMainActivity.class);
            intent.putExtra("subject",getIntent().getStringExtra("subject"));
            startActivity(intent);
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
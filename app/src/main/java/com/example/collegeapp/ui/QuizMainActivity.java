package com.example.collegeapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.example.collegeapp.adapters.QuizQuestionsAdapter;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class QuizMainActivity extends AppCompatActivity {

    TextView quizQuestionNo, quizQuestionTime;
    Button submitQuiz;
    ViewPager2 quizViewPager;
    QuizQuestionsAdapter quizQuestionsAdapter;
    ImageButton quizPreviousQuestion, quizNextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

        quizQuestionNo = findViewById(R.id.quizQuestionNo);
        quizQuestionTime = findViewById(R.id.quizQuestionTime);
        submitQuiz = findViewById(R.id.submitQuiz);
        quizViewPager = findViewById(R.id.quizViewPager);
        quizPreviousQuestion = findViewById(R.id.quizPreviousQuestion);
        quizNextQuestion = findViewById(R.id.quizNextQuestion);

        checkPreviousBtnVisibility();

        SharedPreferences sharedPreferences = getSharedPreferences("CollageApp",0); //mode: MODE_PRIVATE
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("correctAnswers",0);
        editor.putInt("wrongAnswers",0);
        editor.apply();

        quizViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        quizViewPager.setUserInputEnabled(false);

        //set the quiz time
        CountDownTimer timer = new CountDownTimer(600000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String time = new SimpleDateFormat("mm:ss").format(new Date(millisUntilFinished - 1800000));
                quizQuestionTime.setText(time);
                SharedPreferences sharedPreferences = getSharedPreferences("CollageApp",0); //mode: MODE_PRIVATE
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String timeTaken = new SimpleDateFormat("mm:ss").format(new Date(2400000-millisUntilFinished));
                editor.putString("quizTime",timeTaken);
                editor.apply();
            }
            @Override
            public void onFinish() {
                finish();
                sendNextForResult();
            }
        };
        timer.start();

        //set questions
        ArrayList<String> questions = new ArrayList<>();
        questions.add("Question 1");
        questions.add("Question 2");
        questions.add("Question 3");
        questions.add("Question 4");
        questions.add("Question 5");

        //set the options
        ArrayList<String> option1 = new ArrayList<>();
        option1.add("option 1");
        option1.add("option 1");
        option1.add("option 1");
        option1.add("option 1");
        option1.add("option 1");

        ArrayList<String> option2 = new ArrayList<>();
        option2.add("option 2");
        option2.add("option 2");
        option2.add("option 2");
        option2.add("option 2");
        option2.add("option 2");

        ArrayList<String> option3 = new ArrayList<>();
        option3.add("option 3");
        option3.add("option 3");
        option3.add("option 3");
        option3.add("option 3");
        option3.add("option 3");

        ArrayList<String> option4 = new ArrayList<>();
        option4.add("option 4");
        option4.add("option 4");
        option4.add("option 4");
        option4.add("option 4");
        option4.add("option 4");

        //set correct options
        ArrayList<String> answers = new ArrayList<>();
        answers.add("option 1");
        answers.add("option 2");
        answers.add("option 3");
        answers.add("option 4");
        answers.add("option 1");

        quizQuestionsAdapter = new QuizQuestionsAdapter(this,questions,option1,option2,option3,option4,answers);
        quizViewPager.setAdapter(quizQuestionsAdapter);

        //set the previous question
        quizPreviousQuestion.setOnClickListener(v ->{
            quizViewPager.setCurrentItem(quizViewPager.getCurrentItem()-1,true);
            quizQuestionNo.setText(String.valueOf(quizViewPager.getCurrentItem()+1)+"/5");
            checkPreviousBtnVisibility();
            checkNextBtnVisibility(questions);
        });

        //set the next question
        quizNextQuestion.setOnClickListener(v ->{
            quizViewPager.setCurrentItem(quizViewPager.getCurrentItem()+1,true);
            quizQuestionNo.setText(String.valueOf(quizViewPager.getCurrentItem()+1)+"/5");
            checkPreviousBtnVisibility();
            checkNextBtnVisibility(questions);
        });

        submitQuiz.setOnClickListener(v ->{
            sendNextForResult();
        });
    }

    public void checkPreviousBtnVisibility(){

        //hide the previous question button for first question or otherwise visible
        if(quizViewPager.getCurrentItem() == 0){
            quizPreviousQuestion.setVisibility(View.GONE);
        }
        else{
            quizPreviousQuestion.setVisibility(View.VISIBLE);
        }
    }

    public void checkNextBtnVisibility(ArrayList<String> questions){

        //hide the previous question button for first question or otherwise visible
        if(quizViewPager.getCurrentItem() == questions.size()-1){
            quizNextQuestion.setVisibility(View.GONE);
        }
        else{
            quizNextQuestion.setVisibility(View.VISIBLE);
        }
    }

    public void sendNextForResult(){
        //get the correct and wrong answers and also check user can attempt all answers
        SharedPreferences sharedPreferences = getSharedPreferences("CollageApp",0);
        int correctAnswers = sharedPreferences.getInt("correctAnswers",0);
        int wrongAnswers = sharedPreferences.getInt("wrongAnswers",0);
        String time = sharedPreferences.getString("quizTime","0:00");
        if(correctAnswers+wrongAnswers == 5){
            Intent intent = new Intent(this, QuizResultActivity.class);
            intent.putExtra("correctAnswers",correctAnswers);
            intent.putExtra("wrongAnswers",wrongAnswers);
            intent.putExtra("quizTimeTaken",time);
            startActivity(intent);
        }
    }
}
package com.example.collegeapp.ui;

import static android.content.Intent.getIntent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
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
                String timeTaken = new SimpleDateFormat("mm:ss").format(new Date(2400000 - millisUntilFinished + 1000));
                resetTime(timeTaken);
            }
            @Override
            public void onFinish() {
                finish();
                sendNextForResult();
            }
        };
        timer.start();

        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> option1 = new ArrayList<>();
        ArrayList<String> option2 = new ArrayList<>();
        ArrayList<String> option3 = new ArrayList<>();
        ArrayList<String> option4 = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        if(getIntent().getStringExtra("subject").equals("Java")){

            //set questions
            questions.add("Who invented Java Programming?");
            questions.add("Which component is used to compile, debug and execute the java programs?");
            questions.add("What is the extension of java code files?");
            questions.add("Which of the following is not an OOPS concept in Java?");
            questions.add("Which of the following is a type of polymorphism in Java Programming?");

            //set the options
            option1.add("Guido van Rossum");
            option1.add("JRE");
            option1.add(".js");
            option1.add("Polymorphism");
            option1.add("Multiple polymorphism");

            option2.add("James Gosling");
            option2.add("JIT");
            option2.add(".txt");
            option2.add("Inheritance");
            option2.add("Compile time polymorphism");

            option3.add("Dennis Ritchie");
            option3.add("JDK");
            option3.add(".class");
            option3.add("Compilation");
            option3.add("Multilevel polymorphism");

            option4.add("Bjarne Stroustrup");
            option4.add("JVM");
            option4.add(".java");
            option4.add("Encapsulation");
            option4.add("Execution time polymorphism");

            //set correct options
            answers.add("James Gosling");
            answers.add("JDK");
            answers.add(".java");
            answers.add("Compilation");
            answers.add("Compile time polymorphism");
        }
        else if(getIntent().getStringExtra("subject").equals("Python")){

            //set questions
            questions.add("Who developed Python Programming Language?");
            questions.add("Which type of Programming does Python support?");
            questions.add("Is Python case sensitive when dealing with identifiers?");
            questions.add("Which of the following is the correct extension of the Python file?");
            questions.add("All keywords in Python are in ____");

            //set the options
            option1.add("Wick van Rossum");
            option1.add("object-oriented programming");
            option1.add("no");
            option1.add(".python");
            option1.add("Capitalized");

            option2.add("Rasmus Lerdorf");
            option2.add("structured programming");
            option2.add("yes");
            option2.add(".pl");
            option2.add("lower case");

            option3.add("Guido van Rossum");
            option3.add("functional programming");
            option3.add("machine dependent");
            option3.add(".py");
            option3.add("UPPER CASE");

            option4.add("Niene Stom");
            option4.add("all of the mentioned");
            option4.add("none of the mentioned");
            option4.add(".p");
            option4.add("None of the mentioned");

            //set correct options
            answers.add("Guido van Rossum");
            answers.add("all of the mentioned");
            answers.add("yes");
            answers.add(".py");
            answers.add("None of the mentioned");
        }
        else if(getIntent().getStringExtra("subject").equals("C/C++")){

            //set questions
            questions.add("Who invented C++?");
            questions.add("Which of the following is a correct identifier in C++?");
            questions.add("Which of the following approach is used by C++?");
            questions.add("Which of the following type is provided by C++ but not C?");
            questions.add("Which of the following is not a type of Constructor in C++?");

            //set the options
            option1.add("Dennis Ritchie");
            option1.add("VAR_1234");
            option1.add("Left-right");
            option1.add("double");
            option1.add("Default constructor");

            option2.add("Ken Thompson");
            option2.add("$var_name");
            option2.add("Right-left");
            option2.add("float");
            option2.add("Parameterized constructor");

            option3.add("Brian Kernighan");
            option3.add("7VARNAME");
            option3.add("Bottom-up");
            option3.add("int");
            option3.add("Copy constructor");

            option4.add("Bjarne Stroustrup");
            option4.add("7var_name");
            option4.add("Top-down");
            option4.add("bool");
            option4.add("Friend constructor");

            //set correct options
            answers.add("Bjarne Stroustrup");
            answers.add("VAR_1234");
            answers.add("Bottom-up");
            answers.add("bool");
            answers.add("Friend constructor");
        }
        else if(getIntent().getStringExtra("subject").equals("Math")){

            //set questions
            questions.add("2+2=");
            questions.add("3x3=");
            questions.add("4x4=");
            questions.add("5x5=");
            questions.add("6x6=");

            //set the options
            option1.add("4");
            option1.add("10");
            option1.add("15");
            option1.add("20");
            option1.add("36");

            option2.add("5");
            option2.add("9");
            option2.add("16");
            option2.add("21");
            option2.add("38");

            option3.add("6");
            option3.add("8");
            option3.add("17");
            option3.add("22");
            option3.add("45");

            option4.add("6");
            option4.add("7");
            option4.add("18");
            option4.add("25");
            option4.add("50");

            //set correct options
            answers.add("4");
            answers.add("9");
            answers.add("16");
            answers.add("25");
            answers.add("36");
        }


        quizQuestionsAdapter = new QuizQuestionsAdapter(this, questions, option1, option2, option3, option4, answers);
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
            timer.cancel();
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
        String time = sharedPreferences.getString("quizTime","");
        if(correctAnswers+wrongAnswers == 5){
            Intent intent = new Intent(this, QuizResultActivity.class);
            intent.putExtra("correctAnswers",correctAnswers);
            intent.putExtra("wrongAnswers",wrongAnswers);
            intent.putExtra("quizTimeTaken",time);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        resetTime("");
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        resetTime("");
    }

    public void resetTime(String time){
        SharedPreferences sharedPreferences = getSharedPreferences("CollageApp",0); //mode: MODE_PRIVATE
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("quizTime",time);
        editor.apply();
    }
}
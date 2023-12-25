package com.example.collegeapp.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapp.R;

import java.util.ArrayList;
import java.util.Optional;

public class QuizQuestionsAdapter extends RecyclerView.Adapter<QuizQuestionsAdapter.MyViewHolder> {

    Context context;
    ArrayList<String> questions,option1,option2,option3,option4,answers;
    int correctAnswers = 0, wrongAnswers = 0;

    public QuizQuestionsAdapter(Context context, ArrayList<String> questions, ArrayList<String> option1, ArrayList<String> option2, ArrayList<String> option3, ArrayList<String> option4, ArrayList<String> answers) {
        this.context = context;
        this.questions = questions;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answers = answers;
    }

    @NonNull
    @Override
    public QuizQuestionsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_question,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizQuestionsAdapter.MyViewHolder holder, int position) {
        holder.quizQuestionText.setText(questions.get(position));
        holder.quizOption1Text.setText(option1.get(position));
        holder.quizOption2Text.setText(option2.get(position));
        holder.quizOption3Text.setText(option3.get(position));
        holder.quizOption4Text.setText(option4.get(position));

        holder.option1.setOnClickListener(v ->{
            holder.option1Icon.setVisibility(View.VISIBLE);
            if(answers.get(position).equals(option1.get(position))){
                holder.option1.setBackgroundResource(R.color.green);
                holder.option1Icon.setImageResource(R.drawable.correct_icon);
                correctAnswers += 1;
            }
            else{
                holder.option1.setBackgroundResource(R.color.red);
                holder.option1Icon.setImageResource(R.drawable.wrong_icon);
                wrongAnswers += 1;
            }
            setCorrectAnswer(holder,position);
            setBtnUnclickable(holder);
            saveScore(correctAnswers,wrongAnswers);
        });

        holder.option2.setOnClickListener(v ->{
            holder.option2Icon.setVisibility(View.VISIBLE);
            if(answers.get(position).equals(option2.get(position))){
                holder.option2.setBackgroundResource(R.color.green);
                holder.option2Icon.setImageResource(R.drawable.correct_icon);
                correctAnswers += 1;
            }
            else{
                holder.option2.setBackgroundResource(R.color.red);
                holder.option2Icon.setImageResource(R.drawable.wrong_icon);
                wrongAnswers += 1;
            }
            setCorrectAnswer(holder,position);
            setBtnUnclickable(holder);
            saveScore(correctAnswers,wrongAnswers);
        });

        holder.option3.setOnClickListener(v ->{
            holder.option3Icon.setVisibility(View.VISIBLE);
            if(answers.get(position).equals(option3.get(position))){
                holder.option3.setBackgroundResource(R.color.green);
                holder.option3Icon.setImageResource(R.drawable.correct_icon);
                correctAnswers += 1;
            }
            else{
                holder.option3.setBackgroundResource(R.color.red);
                holder.option3Icon.setImageResource(R.drawable.wrong_icon);
                wrongAnswers += 1;
            }
            setCorrectAnswer(holder,position);
            setBtnUnclickable(holder);
            saveScore(correctAnswers,wrongAnswers);
        });

        holder.option4.setOnClickListener(v ->{
            holder.option4Icon.setVisibility(View.VISIBLE);
            if(answers.get(position).equals(option4.get(position))){
                holder.option4.setBackgroundResource(R.color.green);
                holder.option4Icon.setImageResource(R.drawable.correct_icon);
                correctAnswers += 1;
            }
            else{
                holder.option4.setBackgroundResource(R.color.red);
                holder.option4Icon.setImageResource(R.drawable.wrong_icon);
                wrongAnswers += 1;
            }
            setCorrectAnswer(holder,position);
            setBtnUnclickable(holder);
            saveScore(correctAnswers,wrongAnswers);
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public void saveScore(int correct,int wrong){
        //save the correct and wrong answers data
        SharedPreferences sharedPreferences = context.getSharedPreferences("CollageApp",0); //mode: MODE_PRIVATE
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("correctAnswers",correct);
        editor.putInt("wrongAnswers",wrong);
        editor.apply();
    }

    public void setBtnUnclickable(MyViewHolder holder){
        //set unclickable when answer right or wrong
        holder.option1.setClickable(false);
        holder.option2.setClickable(false);
        holder.option3.setClickable(false);
        holder.option4.setClickable(false);
    }

    public void setCorrectAnswer(MyViewHolder holder,int pos){

        //set the correct answer if user selected wrong answer
        if(answers.get(pos).equals(option1.get(pos))){
            holder.option1.setBackgroundResource(R.color.green);
            holder.option1Icon.setVisibility(View.VISIBLE);
            holder.option1Icon.setImageResource(R.drawable.correct_icon);
        }
        else if(answers.get(pos).equals(option2.get(pos))){
            holder.option2.setBackgroundResource(R.color.green);
            holder.option2Icon.setVisibility(View.VISIBLE);
            holder.option2Icon.setImageResource(R.drawable.correct_icon);
        }
        else if(answers.get(pos).equals(option3.get(pos))){
            holder.option3.setBackgroundResource(R.color.green);
            holder.option3Icon.setVisibility(View.VISIBLE);
            holder.option3Icon.setImageResource(R.drawable.correct_icon);
        }
        else if(answers.get(pos).equals(option4.get(pos))){
            holder.option4.setBackgroundResource(R.color.green);
            holder.option4Icon.setVisibility(View.VISIBLE);
            holder.option4Icon.setImageResource(R.drawable.correct_icon);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView quizQuestionText, quizOption1Text, quizOption2Text, quizOption3Text, quizOption4Text;
        LinearLayout option1,option2,option3,option4;
        ImageView option1Icon, option2Icon, option3Icon, option4Icon;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            quizQuestionText = itemView.findViewById(R.id.quizQuestionText);
            quizOption1Text = itemView.findViewById(R.id.quizOption1Text);
            quizOption2Text = itemView.findViewById(R.id.quizOption2Text);
            quizOption3Text = itemView.findViewById(R.id.quizOption3Text);
            quizOption4Text = itemView.findViewById(R.id.quizOption4Text);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);
            option1Icon = itemView.findViewById(R.id.option1Icon);
            option2Icon = itemView.findViewById(R.id.option2Icon);
            option3Icon = itemView.findViewById(R.id.option3Icon);
            option4Icon = itemView.findViewById(R.id.option4Icon);
        }
    }
}

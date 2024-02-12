package com.example.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Terms_and_condition extends AppCompatActivity {

    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_condition);

        getSupportActionBar().setTitle("Terms And Condition");

        textView=findViewById(R.id.pravacy_text);

        String text="BNN college adheres to applicable data protection laws. " +
                "User data will be handled in accordance" +
                "with the privacy policy, which can be found privacy policy.";

        SpannableString spannableString=new SpannableString(text);

        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent next=new Intent(Terms_and_condition.this, pravacy_policy.class);
                startActivity(next);
            }
        };
        spannableString.setSpan(clickableSpan,139,153, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
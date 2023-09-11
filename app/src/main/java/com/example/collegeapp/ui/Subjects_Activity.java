package com.example.collegeapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.example.collegeapp.adapters.ITSubjectFirebaseAdapter;
import com.example.collegeapp.models.Subject;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.Reference;
import java.util.Objects;

public class Subjects_Activity extends AppCompatActivity {

    RecyclerView subjectRV;
    ITSubjectFirebaseAdapter subjectAdapter;
    DatabaseReference ref;
    FirebaseRecyclerOptions<Subject> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        getSupportActionBar().setTitle("Subjects");

        subjectRV = findViewById(R.id.subjectRV);

        ref = FirebaseDatabase.getInstance().getReference();

        //get the subjects from firebase
//        options =
//                new FirebaseRecyclerOptions.Builder<Subject>()
//                        .setQuery(ref.child("Student")
//                                .child("IT")
//                                .child("Semesters")
//                                .child("Sem1")
//                                .child("subjects"), Subject.class)
//                        .build();

        RecyclerView.LayoutManager subjectLayout = new LinearLayoutManager(this);
        subjectRV.setLayoutManager(subjectLayout);

        options = new FirebaseRecyclerOptions.Builder<Subject>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Sub"), Subject.class)
                .build();


        //set layoutmanager and adapter for recyclerview
        subjectAdapter = new ITSubjectFirebaseAdapter(options);
        subjectRV.setAdapter(subjectAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        subjectAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        subjectAdapter.stopListening();
    }
}
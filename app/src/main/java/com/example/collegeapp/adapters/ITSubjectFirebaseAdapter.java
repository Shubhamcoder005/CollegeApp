package com.example.collegeapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegeapp.R;
import com.example.collegeapp.models.Subject;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ITSubjectFirebaseAdapter extends FirebaseRecyclerAdapter<Subject, ITSubjectFirebaseAdapter.SubjectViewHolder> {

    public ITSubjectFirebaseAdapter(@NonNull FirebaseRecyclerOptions<Subject> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull SubjectViewHolder holder, int position, @NonNull Subject model) {

        holder.name.setText(model.getName());
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item, parent, false);
        return new ITSubjectFirebaseAdapter.SubjectViewHolder(view);
    }

    static class SubjectViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.subjectName);
        }
    }
}

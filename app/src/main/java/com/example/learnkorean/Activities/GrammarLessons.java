package com.example.learnkorean.Activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnkorean.R;
import com.example.learnkorean.adaptor.GrammarAdapter;
import com.example.learnkorean.models.GrammarModel;
import com.example.learnkorean.models.TitleModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GrammarLessons extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private GrammarAdapter adapter;
    private List<GrammarModel> grammarModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammarlessons);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_grammar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        grammarModelList = new ArrayList<>();
        adapter = new GrammarAdapter(this, grammarModelList);
        recyclerView.setAdapter(adapter);

        String lessonId = getIntent().getStringExtra("lessonId");

        if (lessonId != null) {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("lessons").child(lessonId).child("grammar");

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    grammarModelList.clear();
                    for (DataSnapshot grammarSnapshot : snapshot.getChildren()) {
                        GrammarModel grammarModel = grammarSnapshot.getValue(GrammarModel.class);
                        if (grammarModel != null) {
                            grammarModelList.add(grammarModel);
                        } else {
                            Log.e("GrammarLessons", "Failed to parse GrammarModel from dataSnapshot");
                        }
                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.e("GrammarLessons", "Firebase database error: " + error.getMessage());
                    Toast.makeText(GrammarLessons.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "Lesson not found", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}

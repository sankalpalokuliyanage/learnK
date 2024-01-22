package com.example.learnkorean.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.learnkorean.R;
import com.example.learnkorean.adaptor.WordAdapter;
import com.example.learnkorean.models.WordModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class WordsActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private WordAdapter adapter;
    private List<WordModel> wordModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        RecyclerView recyclerView = findViewById(R.id.recyclerforWords);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wordModelList = new ArrayList<>();
        adapter = new WordAdapter(this, wordModelList);
        recyclerView.setAdapter(adapter);

        // Get the lessonId passed from WordsFragment
        String lessonId = getIntent().getStringExtra("lessonId");

        // Check if lessonId is not null before proceeding
        if (lessonId != null) {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("lessons").child(lessonId).child("words");

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    wordModelList.clear();
                    for (DataSnapshot itemSnapShot : snapshot.getChildren()) {
                        WordModel wordModel = itemSnapShot.getValue(WordModel.class);
                        wordModelList.add(wordModel);
                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(WordsActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            // Handle the case where lessonId is null (provide feedback or navigate back)
            Toast.makeText(this, "Lesson not found", Toast.LENGTH_SHORT).show();
            finish(); // Close the activity
        }
    }
}
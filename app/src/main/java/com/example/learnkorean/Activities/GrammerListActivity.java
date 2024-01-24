package com.example.learnkorean.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.learnkorean.R;
import com.example.learnkorean.adaptor.WordLAdapter;
import com.example.learnkorean.models.WordLModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GrammerListActivity extends AppCompatActivity implements WordLAdapter.OnItemClickListener {

    private DatabaseReference databaseReference;
    private WordLAdapter adapter;
    private List<WordLModel> modelList;

    ValueEventListener eventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammer_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_grammer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        modelList = new ArrayList<>();

        adapter = new WordLAdapter(this, modelList, this);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("lessons");

        eventListener = databaseReference.orderByChild("lessonName").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                modelList.clear();
                for (DataSnapshot lessonSnapshot : snapshot.getChildren()) {
                    WordLModel wordLModel = new WordLModel();
                    wordLModel.setLessonId(lessonSnapshot.getKey());
                    wordLModel.setLesson(lessonSnapshot.child("lessonName").getValue(String.class));
                    modelList.add(wordLModel);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(GrammerListActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        WordLModel clickedItem = modelList.get(position);
        String selectedLessonId = clickedItem.getLessonId();

        Intent intent = new Intent(this, WordsActivity.class);
        intent.putExtra("lessonId", selectedLessonId);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseReference != null && eventListener != null) {
            databaseReference.removeEventListener(eventListener);
        }
    }
}

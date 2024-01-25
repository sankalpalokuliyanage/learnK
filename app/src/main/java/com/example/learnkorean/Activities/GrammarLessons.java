package com.example.learnkorean.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnkorean.R;
import com.example.learnkorean.adaptor.GrammarAdapter;
import com.example.learnkorean.models.GrammarModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GrammarLessons extends AppCompatActivity implements GrammarAdapter.OnItemClickListener {

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
        adapter = new GrammarAdapter(this, grammarModelList, this);
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
                        grammarModelList.add(grammarModel);
                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(GrammarLessons.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "Lesson not found", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onItemClick(int position) {
        GrammarModel clickedItem = grammarModelList.get(position);
        String selectedGrammarId = clickedItem.getGrammarId();

        Intent intent = new Intent(this, GrammarDetailActivity.class);
        intent.putExtra("grammarId", selectedGrammarId);
        startActivity(intent);
    }
}

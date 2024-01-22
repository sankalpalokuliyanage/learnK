package com.example.learnkorean.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learnkorean.Activities.WordsActivity;
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

public class WordsFragment extends Fragment implements WordLAdapter.OnItemClickListener {

    private DatabaseReference databaseReference;
    private WordLAdapter adapter;
    private List<WordLModel> modelList;

    ValueEventListener eventListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_words, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        modelList = new ArrayList<>();

        adapter = new WordLAdapter(requireContext(), modelList, this);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("lessons");

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
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
                Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onItemClick(int position) {
        WordLModel clickedItem = modelList.get(position);
        String selectedLessonId = clickedItem.getLessonId();

        Intent intent = new Intent(requireContext(), WordsActivity.class);
        intent.putExtra("lessonId", selectedLessonId);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (databaseReference != null && eventListener != null) {
            databaseReference.removeEventListener(eventListener);
        }
    }
}

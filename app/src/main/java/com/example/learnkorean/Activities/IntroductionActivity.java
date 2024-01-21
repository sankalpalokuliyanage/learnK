package com.example.learnkorean.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.learnkorean.R;
import com.example.learnkorean.adaptor.IntroAdapter;
import com.example.learnkorean.models.IntroModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class IntroductionActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    IntroAdapter adapter;
    List<IntroModel> modelList;
    ValueEventListener eventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        modelList = new ArrayList<>();

        adapter = new IntroAdapter(IntroductionActivity.this, modelList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("intro");

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                modelList.clear();
                for (DataSnapshot itemSnapShot : snapshot.getChildren()) {
                    IntroModel introModel = itemSnapShot.getValue(IntroModel.class);
                    modelList.add(introModel);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(IntroductionActivity.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove the ValueEventListener when the activity is destroyed
        if (databaseReference != null && eventListener != null) {
            databaseReference.removeEventListener(eventListener);
        }
    }
}

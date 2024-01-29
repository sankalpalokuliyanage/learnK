package com.example.learnkorean.Activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnkorean.R;
import com.example.learnkorean.models.GrammarModel;
import com.example.learnkorean.models.TitleModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GrammarDetailActivity extends AppCompatActivity {

    private TextView grammarNameTextView;
    private TextView titleNameTextView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_detail);

        Log.d("GrammarDetailActivity", "onCreate");

        grammarNameTextView = findViewById(R.id.textViewGrammarName);
        titleNameTextView = findViewById(R.id.textViewTitleName);
        descriptionTextView = findViewById(R.id.textViewDescription);

        String lessonId = getIntent().getStringExtra("lessonId");
        String grammarId = getIntent().getStringExtra("grammarId");

        if (lessonId != null && grammarId != null) {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                    .getReference().child("lessons").child(lessonId).child("grammar").child(grammarId);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.d("GrammarDetailActivity", "onDataChange");
                    GrammarModel grammarModel = dataSnapshot.getValue(GrammarModel.class);
                    if (grammarModel != null) {
                        updateUI(grammarModel);
                    } else {
                        Log.e("GrammarDetailActivity", "Failed to parse GrammarModel from dataSnapshot");
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.e("GrammarDetailActivity", "Firebase database error: " + databaseError.getMessage());
                    Toast.makeText(GrammarDetailActivity.this, "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {

        }
    }

    private void updateUI(GrammarModel grammarModel) {
        grammarNameTextView.setText(grammarModel.getGrammarName());

        // For simplicity, only displaying the first title
        if (grammarModel.getTitles() != null && !grammarModel.getTitles().isEmpty()) {
            GrammarModel.TitleModel titleModel = grammarModel.getTitles().get(0); // Now using fully qualified import
            titleNameTextView.setText(titleModel.getTitleName());
            descriptionTextView.setText(titleModel.getDescription());
        }
    }
}

package com.example.learnkorean.Activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learnkorean.R;
import com.example.learnkorean.models.GrammarModel;

public class GrammarDetailActivity extends AppCompatActivity {

    private TextView grammarNameTextView;
    private TextView titleNameTextView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_detail);

        grammarNameTextView = findViewById(R.id.textViewGrammarName);
        titleNameTextView = findViewById(R.id.textViewTitleName);
        descriptionTextView = findViewById(R.id.textViewDescription);

        String grammarId = getIntent().getStringExtra("grammarId");

        if (grammarId != null) {
            // TODO: Fetch detailed information about the selected grammar from the database
            // For now, using sample data
            displaySampleGrammarDetails();
        } else {
            // Handle the case where grammarId is null
            // You may want to show an error message or navigate back
        }
    }

    private void displaySampleGrammarDetails() {
        // Sample GrammarModel to demonstrate the display
        GrammarModel sampleGrammar = new GrammarModel();
        sampleGrammar.setGrammarName("Sample Grammar");
        sampleGrammar.setTitleName("Sample Title");
        sampleGrammar.setDescription("This is a sample description for the grammar.");

        grammarNameTextView.setText(sampleGrammar.getGrammarName());
        titleNameTextView.setText(sampleGrammar.getTitleName());
        descriptionTextView.setText(sampleGrammar.getDescription());
    }
}

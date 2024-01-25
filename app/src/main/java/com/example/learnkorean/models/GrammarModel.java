package com.example.learnkorean.models;

import java.util.Map;

public class GrammarModel {
    private String grammarName;
    private Map<String, TitleModel> titles; // Map to hold titles

    public GrammarModel() {
        // Required empty constructor for Firebase
    }

    public GrammarModel(String grammarName, Map<String, TitleModel> titles) {
        this.grammarName = grammarName;
        this.titles = titles;
    }

    // Add getters and setters
    public String getGrammarName() {
        return grammarName;
    }

    public void setGrammarName(String grammarName) {
        this.grammarName = grammarName;
    }

    public Map<String, TitleModel> getTitles() {
        return titles;
    }

    public void setTitles(Map<String, TitleModel> titles) {
        this.titles = titles;
    }
}

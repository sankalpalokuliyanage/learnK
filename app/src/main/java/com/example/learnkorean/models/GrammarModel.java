package com.example.learnkorean.models;

public class GrammarModel {
    private String grammarId;
    private String grammarName;
    private String titleName;
    private String description;

    // Constructor
    public GrammarModel() {
        // Default constructor required for Firebase
    }

    // Getter methods
    public String getGrammarId() {
        return grammarId;
    }

    public String getGrammarName() {
        return grammarName;
    }

    public String getTitleName() {
        return titleName;
    }

    public String getDescription() {
        return description;
    }

    // Setter methods (if needed)

    public void setGrammarId(String grammarId) {
        this.grammarId = grammarId;
    }

    public void setGrammarName(String grammarName) {
        this.grammarName = grammarName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

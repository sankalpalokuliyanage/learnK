package com.example.learnkorean.models;

public class TitleModel {
    private String description;
    private String titleName;

    public TitleModel() {
        // Required empty constructor for Firebase
    }

    public TitleModel(String description, String titleName) {
        this.description = description;
        this.titleName = titleName;
    }

    // Add getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}

package com.example.learnkorean.models;

public class TitleModel {
    private String titleName;
    private String description;

    public TitleModel() {
        // Required empty constructor for Firebase
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

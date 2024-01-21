package com.example.learnkorean.models;

public class IntroModel {
//    private String image;
    private String title;
    private String paragraph;

    public IntroModel() {}

    public IntroModel( String title, String paragraph) {
//        this.image = image;
        this.title = title;
        this.paragraph = paragraph;
    }

//    public String getImage() {
//        return image;
//    }

    public String getTitle() {
        return title;
    }

    public String getParagraph() {
        return paragraph;
    }
}

package com.example.learnkorean.models;

public class WordModel {
    private String lessonId;
    private String korean;
    private String english;
    private String sentence;

    public WordModel() {
        // Default constructor required for Firebase
    }

    public WordModel(String lessonId, String korean, String english, String sentence) {
        this.lessonId = lessonId;
        this.korean = korean;
        this.english = english;
        this.sentence = sentence;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public String getKorean() {
        return korean;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}

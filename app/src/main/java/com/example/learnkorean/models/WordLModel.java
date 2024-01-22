package com.example.learnkorean.models;

public class WordLModel {
    private String lessonId;
    private String lesson;

    public WordLModel() {
        // Default constructor required for Firebase
    }

    public WordLModel(String lessonId, String lesson) {
        this.lessonId = lessonId;
        this.lesson = lesson;
    }

    public String getLessonId() {
        return lessonId;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
}

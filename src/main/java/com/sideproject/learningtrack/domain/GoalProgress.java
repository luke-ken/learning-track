package com.sideproject.learningtrack.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "goalprogress")
public class GoalProgress {

    @Id
    public String id;

    private String name;
    private int duration;
    private String note;

    public GoalProgress(String name, int duration, String note) {
        this.name = name;
        this.duration = duration;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}

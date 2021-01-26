package com.sideproject.learningtrack.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "post")
@Getter
@Setter
public class Post {

    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    private String title;
    private String topic;
    private int duration;
    private String note;

    public Post(String title, String topic, int duration, String note) {
        this.title = title;
        this.topic = topic;
        this.duration = duration;
        this.note = note;
    }

}

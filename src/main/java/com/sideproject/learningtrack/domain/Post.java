package com.sideproject.learningtrack.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "post")
@Data
public class Post {

    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    private String title;
    private String[] tags;
    private String timestamp;
    private String content;

    public Post(String title, String[] tags, String timestamp, String content) {
        this.title = title;
        this.tags = tags;
        this.timestamp = timestamp;
        this.content = content;
    }

}

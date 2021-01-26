package com.sideproject.learningtrack.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "topic")
@Getter
@Setter
public class Topic {

    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    @Indexed(unique = true)
    private String name;

    private String type;

    public Topic(String name, String type) {
        this.name = name;
        this.type = type;
    }

}

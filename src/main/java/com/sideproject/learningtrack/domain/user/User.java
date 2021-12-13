package com.sideproject.learningtrack.domain.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "user")
public class User {

    @Id
    @Getter
    private String id;
    @Getter
    private String username;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private Set<Role> role;

    public User(String username, String password, Set<Role> role) {
        this.username = username.toLowerCase();
        this.password = password;
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username.toLowerCase();
    }

}

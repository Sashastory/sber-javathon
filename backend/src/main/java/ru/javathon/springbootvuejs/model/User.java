package ru.javathon.springbootvuejs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("user")
@ToString
public class User {

    public User() {
    }

    private String id;

    private String name;
    private String userpicture;
    private String email;
    private String gender;

}


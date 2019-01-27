package de.jonashackt.springbootvuejs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "user_table")
@ToString
public class User {

    public User() {
    }

    @Id
    private String id;

    private String name;
    private String userpicture;
    private String email;
    private String gender;

}

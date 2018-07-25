package com.capgemini.boardgames.model;

import com.capgemini.boardgames.model.playability.Playability;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    private long id;
    private String firstname;
    private String lastname;
    private String motto;
    private String email;
    private String password;
    private Playability playability;

    public User() {
        this.playability = new Playability();
    }

    public User(long id, String firstname, String lastname, String motto, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.motto = motto;
        this.email = email;
        this.playability = new Playability();
    }
}
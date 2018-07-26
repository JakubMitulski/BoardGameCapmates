package com.capgemini.boardgames.model;

import com.capgemini.boardgames.model.playability.Playability;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class User {

    private long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String motto;
    @Email
    private String email;
    @Size(min = 4, max = 255, message = "Password must be at least 4 characters long")
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
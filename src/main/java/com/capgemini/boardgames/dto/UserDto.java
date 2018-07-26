package com.capgemini.boardgames.dto;

import com.capgemini.boardgames.model.playability.Playability;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDto {

    private long id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @NotNull
    private String motto;
    @NotNull
    private String email;
    @Size(min = 4, max = 255, message = "Password must be at least 4 characters long")
    private String password;

    private Playability playability;


    public UserDto() {
    }

    public UserDto(long id, String firstname, String lastname, String motto, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.motto = motto;
        this.email = email;
        this.password = password;
        this.playability = new Playability();
    }
}

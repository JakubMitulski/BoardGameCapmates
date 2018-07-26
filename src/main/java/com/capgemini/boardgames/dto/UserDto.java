package com.capgemini.boardgames.dto;

import com.capgemini.boardgames.model.playability.Playability;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
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
}

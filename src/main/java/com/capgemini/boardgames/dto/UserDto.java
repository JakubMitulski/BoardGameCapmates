package com.capgemini.boardgames.dto;

import com.capgemini.boardgames.model.playability.Playability;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private long id;
    private String firstname;
    private String lastname;
    private String motto;
    private String email;
    private String password;
    private Playability playability;

    public UserDto() {
    }
}

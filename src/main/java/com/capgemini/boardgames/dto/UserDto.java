package com.capgemini.boardgames.dto;

import com.capgemini.boardgames.model.Availability;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private long id;
    private String firstname;
    private String lastname;
    private String motto;
    private String email;
    private Availability availability;
    private List gameHistory;
}

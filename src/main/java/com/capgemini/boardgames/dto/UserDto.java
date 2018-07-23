package com.capgemini.boardgames.dto;

import com.capgemini.boardgames.model.Availability;
import com.capgemini.boardgames.model.UserLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private String firstname;
    private String lastname;
    private String motto;
    private String email;
    private Double rankingPosition;
    private UserLevel userLevel;
    private Availability availability;
    private List gameCollection;
    private List gameHistory;
}

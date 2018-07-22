package com.capgemini.boardgames.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    private String firstname;
    private String lastname;
    private String motto;
    private String password;
    private Availability availability;
    private List gameCollection;
    private List gameHistory;
    private Double rankingPosition;
    private UserLevel userLevel;

    public User() {
        this.gameCollection = new ArrayList();
        this.gameHistory = new ArrayList();
    }
}
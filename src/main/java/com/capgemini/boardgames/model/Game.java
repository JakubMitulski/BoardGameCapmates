package com.capgemini.boardgames.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {

    private long id;
    @NotNull
    private String name;
    @NotNull
    private int minPlayerNumber;
    @NotNull
    private int maxPlayerNumber;

    private List<Long> subscribersList;


    public Game() {
        this.subscribersList = new ArrayList<>();
    }

    public Game(long id, String name, int minPlayerNumber, int maxPlayerNumber) {
        this.id = id;
        this.name = name;
        this.minPlayerNumber = minPlayerNumber;
        this.maxPlayerNumber = maxPlayerNumber;
        this.subscribersList = new ArrayList<>();
    }
}
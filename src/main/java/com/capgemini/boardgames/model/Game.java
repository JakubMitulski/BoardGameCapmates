package com.capgemini.boardgames.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {

    private long id;
    private String name;
    private int minPlayerNumber;
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
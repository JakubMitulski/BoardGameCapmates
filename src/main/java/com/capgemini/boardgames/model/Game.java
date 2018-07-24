package com.capgemini.boardgames.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {

    private int id;
    private String name;
    private int minPlayerNumber;
    private int maxPlayerNumber;
    private List<String> subscribersList;

    public Game() {
        this.subscribersList = new ArrayList<>();
    }

    public Game(int id, String name, int minPlayerNumber, int maxPlayerNumber) {
        this.id = id;
        this.name = name;
        this.minPlayerNumber = minPlayerNumber;
        this.maxPlayerNumber = maxPlayerNumber;
        this.subscribersList = new ArrayList<>();
    }
}
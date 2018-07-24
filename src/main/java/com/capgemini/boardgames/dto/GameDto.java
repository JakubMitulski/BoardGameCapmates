package com.capgemini.boardgames.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameDto {

    private long id;
    private String name;
    private int minPlayerNumber;
    private int maxPlayerNumber;
    private List<String> subscribersList;

    public GameDto(long id, String name, int minPlayerNumber, int maxPlayerNumber) {
        this.id = id;
        this.name = name;
        this.minPlayerNumber = minPlayerNumber;
        this.maxPlayerNumber = maxPlayerNumber;
    }
}
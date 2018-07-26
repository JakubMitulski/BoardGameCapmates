package com.capgemini.boardgames.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameDto {

    private long id;
    @NotNull
    private String name;
    @NotNull
    private int minPlayerNumber;
    @NotNull
    private int maxPlayerNumber;

    private List<Long> subscribersList;


    public GameDto() {
    }

    public GameDto(long id, String name, int minPlayerNumber, int maxPlayerNumber) {
        this.id = id;
        this.name = name;
        this.minPlayerNumber = minPlayerNumber;
        this.maxPlayerNumber = maxPlayerNumber;
        this.subscribersList = new ArrayList<>();
    }
}
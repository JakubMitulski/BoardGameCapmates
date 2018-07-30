package com.capgemini.boardgames.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameByRequestDTO {

    private String gameName;
    private Integer minPlayersNumber;
    private Integer maxPlayersNumber;
    private List<Long> subscribersList;

    public GameByRequestDTO() {
    }

    public GameByRequestDTO(String gameName, Integer minPlayersNumber, Integer maxPlayersNumber, List<Long> subscribersList) {
        this.gameName = gameName;
        this.minPlayersNumber = minPlayersNumber;
        this.maxPlayersNumber = maxPlayersNumber;
        this.subscribersList = subscribersList;
    }
}

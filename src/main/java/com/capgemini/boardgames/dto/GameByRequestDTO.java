package com.capgemini.boardgames.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameByRequestDTO {

    private String gameName;
    private Integer minPlayersNumber;
    private Integer maxPlayerNumber;
    private List<Long> subscribersList;
}

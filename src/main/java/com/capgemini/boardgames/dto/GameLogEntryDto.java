package com.capgemini.boardgames.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameLogEntryDto {

    private long userId;
    private long gameId;
    private long result;
    private long sessionId;

    public GameLogEntryDto() {
    }
}

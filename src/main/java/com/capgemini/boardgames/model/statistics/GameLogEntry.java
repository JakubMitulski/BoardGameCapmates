package com.capgemini.boardgames.model.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameLogEntry {

    private long userId;
    private long gameId;
    private long result;
    private long sessionId;
}

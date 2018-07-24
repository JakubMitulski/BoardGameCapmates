package com.capgemini.boardgames.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameLogEntry {

    private long userId;
    private long gameId;
    private int result;
    private long sessionId;
}

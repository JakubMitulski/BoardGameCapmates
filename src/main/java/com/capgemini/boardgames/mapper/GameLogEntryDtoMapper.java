package com.capgemini.boardgames.mapper;

import com.capgemini.boardgames.dto.GameLogEntryDto;
import com.capgemini.boardgames.model.statistics.GameLogEntry;
import org.springframework.stereotype.Component;

@Component
public class GameLogEntryDtoMapper {

    public GameLogEntryDto map(GameLogEntry gameLogEntry){
        GameLogEntryDto gameLogEntryDto = new GameLogEntryDto();
        gameLogEntryDto.setGameId(gameLogEntry.getGameId());
        gameLogEntryDto.setUserId(gameLogEntry.getUserId());
        gameLogEntryDto.setResult(gameLogEntry.getResult());
        gameLogEntryDto.setSessionId(gameLogEntry.getSessionId());
        return gameLogEntryDto;
    }
}

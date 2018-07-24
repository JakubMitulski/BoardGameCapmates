package com.capgemini.boardgames.mapper;

import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameDtoToGameMapper {

    public Game map(GameDto gameDto) {
        Game game = new Game();
        game.setId(gameDto.getId());
        game.setName(gameDto.getName());
        game.setMinPlayerNumber(gameDto.getMinPlayerNumber());
        game.setMaxPlayerNumber(gameDto.getMaxPlayerNumber());
        return game;
    }
}

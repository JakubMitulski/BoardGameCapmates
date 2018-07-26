package com.capgemini.boardgames.mapper;

import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameDtoMapper {

    public Game map(GameDto gameDto) {
        Game game = new Game();
        game.setId(gameDto.getId());
        game.setName(gameDto.getName());
        game.setMinPlayerNumber(gameDto.getMinPlayerNumber());
        game.setMaxPlayerNumber(gameDto.getMaxPlayerNumber());
        game.setSubscribersList(gameDto.getSubscribersList());
        return game;
    }

    public GameDto map(Game game) {
        GameDto gameDto = new GameDto();
        gameDto.setId(game.getId());
        gameDto.setName(game.getName());
        gameDto.setMinPlayerNumber(game.getMinPlayerNumber());
        gameDto.setMaxPlayerNumber(game.getMaxPlayerNumber());
        gameDto.setSubscribersList(game.getSubscribersList());
        return gameDto;
    }
}

package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.mapper.GameDtoMapper;
import com.capgemini.boardgames.model.Game;
import com.capgemini.boardgames.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameDtoMapper gameDtoMapper;


    public List<GameDto> getGamesFromUserGamesList(long userId) {
        List<Game> games = gameRepository.getUserGames(userId);
        List<GameDto> gamesDto = new ArrayList<>();

        for (Game game : games) {
            gamesDto.add(gameDtoMapper.map(game));
        }
        return gamesDto;
    }


    public void removeGameFromUserGameList(String gameName, long userId) {
        gameRepository.removeGame(gameName, userId);
    }


    public void addGameToUserGameList(String gameName, long userId) {
        gameRepository.addGame(gameName, userId);
    }


    public void addNewGameToSystem(GameDto gameDto) {
        gameRepository.addNewGameToGamesCollection(gameDtoMapper.map(gameDto));
    }
}

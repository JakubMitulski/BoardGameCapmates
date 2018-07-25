package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.mapper.GameDtoToGameMapper;
import com.capgemini.boardgames.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    private GameDtoToGameMapper gameDtoToGameMapper;


    public List getGamesFromUserGamesList(long userId) {
        return gameRepository.getUserGames(userId);
    }


    public void removeGameFromUserGameList(String gameName, long userId) {
        gameRepository.removeGame(gameName, userId);
    }


    public void addGameToUserGameList(String gameName, long userId) {
        gameRepository.addGame(gameName, userId);
    }


    public void addNewGameToSystem(GameDto gameDto) {
        gameRepository.addNewGameToGamesCollection(gameDtoToGameMapper.map(gameDto));
    }
}

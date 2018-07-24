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


    public List getGamesFromUserGamesList(String email) {
        return gameRepository.getUserGames(email);
    }


    public void removeGameFromUserGameList(String gameName, String email) {
        gameRepository.removeGame(gameName, email);
    }


    public void addGameToUserGameList(String gameName, String email) {
        gameRepository.addGame(gameName, email);
    }


    public void addNewGameToSystem(GameDto gameDto) {
        gameRepository.addNewGameToGamesCollection(gameDtoToGameMapper.map(gameDto));
    }
}

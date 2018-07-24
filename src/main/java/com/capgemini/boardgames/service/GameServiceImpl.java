package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.mapper.GameDtoToGameMapper;
import com.capgemini.boardgames.model.Game;
import com.capgemini.boardgames.repository.GameRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameRepositoryImpl gameRepository;

    @Autowired
    private GameDtoToGameMapper gameDtoToGameMapper;

    @Override
    public List getGamesFromUserGamesList(String email) {
        return gameRepository.getUserGames(email);
    }

    @Override
    public void removeGameFromUserGameList(String gameName, String email) {
        gameRepository.removeGame(gameName, email);
    }

    @Override
    public void addGameToUserGameList(String gameName, String email) {
        gameRepository.addGame(gameName, email);
    }

    @Override
    public void addNewGameToSystem(GameDto gameDto) {
        gameRepository.addNewGameToGamesCollection(gameDtoToGameMapper.map(gameDto));
    }
}

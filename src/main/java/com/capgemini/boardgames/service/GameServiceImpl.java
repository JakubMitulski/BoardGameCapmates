package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.games.Game;
import com.capgemini.boardgames.repository.GameRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameRepositoryImpl gameRepository;

    @Override
    public List getGamesFromUserGamesList(Integer userId) {
        return gameRepository.getUserGames(userId);
    }

    @Override
    public void removeGameFromUserGameList(Game game, Integer userId) {
        gameRepository.removeGame(game, userId);
    }

    @Override
    public void addGameToUserGameList(Game game, Integer userId) {
        gameRepository.addGame(game, userId);
    }
}

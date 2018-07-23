package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.games.Game;
import com.capgemini.boardgames.repository.GameRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameRepositoryImpl gameRepository;

    @Override
    public List getGamesFromUserGamesList(String email) {
        return gameRepository.getUserGames(email);
    }

    @Override
    public void removeGameFromUserGameList(Game game, String email) {
        gameRepository.removeGame(game, email);
    }

    @Override
    public void addGameToUserGameList(Game game, String email) {
        gameRepository.addGame(game, email);
    }
}

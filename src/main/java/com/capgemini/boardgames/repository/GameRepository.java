package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.games.Game;

import java.util.List;

public interface GameRepository {

    List<Game> getUserGames(Integer userId);

    void addGame(Game game, Integer userId);

    void removeGame(Game game, Integer userId);
}

package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.Game;

import java.util.List;

public interface GameRepository {

    List<Game> getUserGames(long id);

    Game findGameByName(String gameName);

    void addGame(String gameName, long userId);

    void removeGame(String gameName, long userId);

    void addNewGameToGamesCollection(Game game);
}

package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.Game;

import java.util.List;
import java.util.Set;

public interface GameRepository {

    List<Game> getUserGames(long id);

    Game findGameByName(String gameName);

    void addGame(String gameName, long userId);

    void removeGame(String gameName, long userId);

    void addNewGameToGamesCollection(Game game);

    List<Long> getUsersWithSpecifiedGame(String gameName);

    boolean checkIfGamesCollectionContainsGame(String gameName);
}

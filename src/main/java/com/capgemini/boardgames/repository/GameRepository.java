package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.Game;

import java.util.List;

public interface GameRepository {

    List<Game> getUserGames(long id);

    Game getGameByName(String gameName);

    void addGame(String gameName, long userId);

    void removeGame(String gameName, long userId);

    void addNewGameToGamesCollection(Game game);

    List<Long> getUsersWithSpecifiedGame(String gameName);

    boolean checkIfGamesCollectionContainsGame(String gameName);

    List<Game> getGameByMinPlayersNumber(Integer minPlayersNumber);

    List<Game> getGameByMaxPlayersNumber(Integer maxPlayerNumber);

    List<Game> getGamesOfSubscribers(List<Long> subscribersList);
}

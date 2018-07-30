package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.exception.NoSuchGameMaxPlayerException;
import com.capgemini.boardgames.exception.NoSuchGameMinPlayerException;
import com.capgemini.boardgames.exception.NoSuchGameNameException;
import com.capgemini.boardgames.exception.NoSuchGameSubscribersException;
import com.capgemini.boardgames.model.Game;

import java.util.List;
import java.util.Set;

public interface GameRepository {

    List<Game> getUserGames(long id);

    Game getGameByName(String gameName);

    void addGame(String gameName, long userId);

    void removeGame(String gameName, long userId);

    void addNewGameToGamesCollection(Game game);

    List<Long> getUsersWithSpecifiedGame(String gameName);

    boolean checkIfGamesCollectionContainsGame(String gameName);

    Set<Game> filterGameByMinPlayersNumber(Integer minPlayersNumber) throws NoSuchGameMinPlayerException;

    Set<Game> filterGameByMaxPlayersNumber(Integer maxPlayerNumber) throws NoSuchGameMaxPlayerException;

    Set<Game> filterGamesOfSubscribers(List<Long> subscribersList) throws NoSuchGameSubscribersException;

    Set<Game> filterGameByName(String gameName) throws NoSuchGameNameException;

    Set<Game> getTempGamesCollection();

    void clearTempGamesCollection();
}

package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.Game;

import java.util.List;

public interface GameRepository {

    List<Game> getUserGames(String email);

    void addGame(String gameName, String email);

    void removeGame(String gameName, String email);

    void addNewGameToGamesCollection(Game game);
}

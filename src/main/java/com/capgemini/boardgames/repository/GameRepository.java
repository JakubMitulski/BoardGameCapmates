package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.games.Game;

import java.util.List;

public interface GameRepository {

    List<Game> getUserGames(String email);

    void addGame(Game game, String email);

    void removeGame(Game game, String email);
}

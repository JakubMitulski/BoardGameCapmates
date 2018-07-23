package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.games.Game;

import java.util.List;

public interface GameService {

    List getGamesFromUserGamesList(String email);

    void removeGameFromUserGameList(Game game, String email);

    void addGameToUserGameList(Game game, String email);
}

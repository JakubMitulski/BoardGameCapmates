package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.games.Game;

import java.util.List;

public interface GameService {

    List getGamesFromUserGamesList(Integer userId);

    void removeGameFromUserGameList(Game game, Integer userId);

    void addGameToUserGameList(Game game, Integer userId);
}

package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.Game;
import com.capgemini.boardgames.model.User;

public interface GameService {

    void showUserGameList(User user);

    void removeGameFromUserGameList(User user, Game game);

    void addGameToUserGameList(User user);

}

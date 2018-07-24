package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.model.Game;

import java.util.List;

public interface GameService {

    List getGamesFromUserGamesList(String email);

    void removeGameFromUserGameList(String gameName, String email);

    void addGameToUserGameList(String gameName, String email);

    void addNewGameToSystem(GameDto gameDto);
}

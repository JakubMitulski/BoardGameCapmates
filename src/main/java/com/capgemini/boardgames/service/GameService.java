package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.GameByRequestDTO;
import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.mapper.GameDtoMapper;
import com.capgemini.boardgames.model.Game;
import com.capgemini.boardgames.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameDtoMapper gameDtoMapper;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameDto> getGamesFromUserGamesList(long userId) {
        List<Game> games = gameRepository.getUserGames(userId);
        List<GameDto> gamesDto = new ArrayList<>();

        for (Game game : games) {
            gamesDto.add(gameDtoMapper.map(game));
        }
        return gamesDto;
    }


    public void removeGameFromUserGameList(String gameName, long userId) {
        gameRepository.removeGame(gameName, userId);
    }


    public void addGameToUserGameList(GameDto gameDto, long userId) {
        boolean contains = gameRepository.checkIfGamesCollectionContainsGame(gameDto.getName());

        if (!contains) {
            addNewGameToSystem(gameDto);
        }

        gameRepository.addGame(gameDto.getName(), userId);
    }


    public void addNewGameToSystem(GameDto gameDto) {
        gameRepository.addNewGameToGamesCollection(gameDtoMapper.map(gameDto));
    }

    public List<GameDto> findGamesByParams(GameByRequestDTO gameByRequestDTO) throws Exception {
        String gameName = gameByRequestDTO.getGameName();
        Integer minPlayersNumber = gameByRequestDTO.getMinPlayersNumber();
        Integer maxPlayersNumber = gameByRequestDTO.getMaxPlayersNumber();
        List<Long> subscribersList = gameByRequestDTO.getSubscribersList();

        List<GameDto> gameDtoList = new ArrayList<>();

        if (gameName != null) {
            gameRepository.filterGameByName(gameName);
        }
        if (minPlayersNumber != null) {
            gameRepository.filterGameByMinPlayersNumber(minPlayersNumber);
        }
        if (maxPlayersNumber != null) {
            gameRepository.filterGameByMaxPlayersNumber(maxPlayersNumber);
        }
        if (subscribersList != null && !subscribersList.isEmpty()) {
            gameRepository.filterGamesOfSubscribers(subscribersList);
        }

        Set<Game> gameSet = gameRepository.getTempGamesCollection();

        for (Game game : gameSet) {
            gameDtoList.add(gameDtoMapper.map(game));
        }

        gameRepository.clearTempGamesCollection();

        return gameDtoList;
    }
}

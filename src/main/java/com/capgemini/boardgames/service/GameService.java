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

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameDtoMapper gameDtoMapper;


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

        if (!contains){
            addNewGameToSystem(gameDto);
        }

        gameRepository.addGame(gameDto.getName(), userId);
    }


    public void addNewGameToSystem(GameDto gameDto) {
        gameRepository.addNewGameToGamesCollection(gameDtoMapper.map(gameDto));
    }

    public List<GameDto> findGamesByParams(GameByRequestDTO gameByRequestDTO) {
        String gameName = gameByRequestDTO.getGameName();
        Integer minPlayersNumber = gameByRequestDTO.getMinPlayersNumber();
        Integer maxPlayerNumber = gameByRequestDTO.getMaxPlayerNumber();
        List<Long> subscribersList = gameByRequestDTO.getSubscribersList();

        List<Game> resultGameList = new ArrayList<>();

        if (gameName != null){
            gameRepository.getGameByName(gameName);
            //TODO zaimplementowac getgamebyname w repo
        }
        //stworzyc ify z warunkami, w kazdym ifie rezult dodaje cos do listywynikowej


        return null;
    }
}

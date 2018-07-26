package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.GameLogEntryDto;
import com.capgemini.boardgames.mapper.GameLogEntryDtoMapper;
import com.capgemini.boardgames.model.Game;
import com.capgemini.boardgames.model.statistics.*;
import com.capgemini.boardgames.repository.GameRepository;
import com.capgemini.boardgames.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameLogEntryDtoMapper gameLogEntryDtoMapper;


    public List<GameLogEntryDto> getUserGamesHistory(long userId) {
        List<GameLogEntry> gameLogEntryList = statisticsRepository.getUserLogs(userId);
        List<GameLogEntryDto> gameLogEntryListDto = new ArrayList<>();

        for (GameLogEntry gle : gameLogEntryList) {
            gameLogEntryListDto.add(gameLogEntryDtoMapper.map(gle));
        }
        return gameLogEntryListDto;
    }


    public long getUserRankingPos(long gameId, long userId) {
        List<GameLogEntry> gameLogs = statisticsRepository.getGameLogs(gameId);
        return new RankingPositionManager().getRankingPosition(gameLogs, userId);
    }


    public UserLevel getUserLevel(long gameId, long userId) {
        List<GameLogEntry> userGameLogs = statisticsRepository
                .getGameLogs(gameId)
                .stream()
                .filter(gameLogEntry -> gameLogEntry.getUserId() == userId)
                .collect(Collectors.toList());

        long overallResult = 0;

        for (GameLogEntry log : userGameLogs) {
            overallResult += log.getResult();
        }

        return new UserLevelDistributor().getLevel(overallResult);
    }


    public List<UserStatisticsResultObj> getUserStatistics(long userId) {
        List<Game> userGames = gameRepository.getUserGames(userId);
        List<UserStatisticsResultObj> userGamesStatistics = new ArrayList<>();

        for (Game game : userGames) {
            long gameId = game.getId();
            long gameRankingPosition = getUserRankingPos(gameId, userId);
            UserLevel gameLevel = getUserLevel(gameId, userId);
            userGamesStatistics.add(new UserStatisticsResultObj(game.getName(), gameRankingPosition, gameLevel));
        }

        return userGamesStatistics;
    }
}

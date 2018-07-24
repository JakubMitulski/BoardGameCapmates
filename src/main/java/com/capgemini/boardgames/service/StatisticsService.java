package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.statistics.GameLogEntry;
import com.capgemini.boardgames.model.statistics.UserLevel;
import com.capgemini.boardgames.model.statistics.RankingPositionManager;
import com.capgemini.boardgames.model.statistics.UserLevelDistributor;
import com.capgemini.boardgames.repository.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticsService {

    private StatisticsRepository statisticsRepository;


    public List getUserGamesHistory(long userId) {
        //TODO dodać DTO listy
        return statisticsRepository.getUserLogs(userId);
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
}

package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.GameLogEntry;
import com.capgemini.boardgames.model.statistics.RankingPositionManager;
import com.capgemini.boardgames.repository.StatisticsRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    private StatisticsRepositoryImpl statisticsRepository;


    public List getUserGamesHistory(long userId) {
        //TODO dodać DTO listy
        return statisticsRepository.getUserLogs(userId);
    }


    public long getUserRankingPos(Long gameId, Long userId) {
        List<GameLogEntry> gameLogs = statisticsRepository.getGameLogs(gameId);
        return new RankingPositionManager().getRankingPosition(gameLogs, userId);
    }
}

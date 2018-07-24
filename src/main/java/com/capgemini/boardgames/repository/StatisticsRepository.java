package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.statistics.GameLogEntry;

import java.util.List;

public interface StatisticsRepository {

    List<GameLogEntry> getUserLogs(long userId);

    List<GameLogEntry> getGameLogs(long gameId);
}

package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.GameLogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StatisticsRepositoryImpl implements StatisticsRepository {

    private List<GameLogEntry> historyLogsCollection;

    public StatisticsRepositoryImpl() {
        historyLogsCollection = new ArrayList<>();
        this.historyLogsCollection.add(new GameLogEntry(1, 1, 10, 100));
        this.historyLogsCollection.add(new GameLogEntry(2, 1, 1, 100));
        this.historyLogsCollection.add(new GameLogEntry(1, 1, 10, 120));
        this.historyLogsCollection.add(new GameLogEntry(4, 1, 1, 120));
        this.historyLogsCollection.add(new GameLogEntry(1, 3, 1, 140));
        this.historyLogsCollection.add(new GameLogEntry(2, 3, 1, 140));
        this.historyLogsCollection.add(new GameLogEntry(3, 3, 10, 140));
        this.historyLogsCollection.add(new GameLogEntry(4, 3, 1, 140));
    }

    @Override
    public List getUserLogs(long userId) {
        return historyLogsCollection
                .stream()
                .filter(gameLogEntry -> gameLogEntry.getUserId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public List getGameLogs(long gameId) {
        return historyLogsCollection
                .stream()
                .filter(gameLogEntry -> gameLogEntry.getGameId() == gameId)
                .collect(Collectors.toList());
    }


}
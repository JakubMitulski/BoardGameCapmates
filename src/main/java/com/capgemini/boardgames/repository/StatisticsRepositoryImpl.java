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
        this.historyLogsCollection.add(new GameLogEntry(1L, 1L, 10L, 100L));
        this.historyLogsCollection.add(new GameLogEntry(2L, 1L, 1L, 100L));
        this.historyLogsCollection.add(new GameLogEntry(1L, 1L, 10L, 120L));
        this.historyLogsCollection.add(new GameLogEntry(4L, 1L, 1L, 120L));
        this.historyLogsCollection.add(new GameLogEntry(1L, 3L, 1L, 140L));
        this.historyLogsCollection.add(new GameLogEntry(2L, 3L, 1L, 140L));
        this.historyLogsCollection.add(new GameLogEntry(3L, 3L, 10L, 140L));
        this.historyLogsCollection.add(new GameLogEntry(4L, 3L, 1L, 140L));
    }

    @Override
    public List getUserLogs(Long userId) {
        return historyLogsCollection
                .stream()
                .filter(gameLogEntry -> gameLogEntry.getUserId() == userId)
                .collect(Collectors.toList());
    }

    public List getGameLogs(Long gameId) {
        return historyLogsCollection
                .stream()
                .filter(gameLogEntry -> gameLogEntry.getGameId() == gameId)
                .collect(Collectors.toList());
    }


}

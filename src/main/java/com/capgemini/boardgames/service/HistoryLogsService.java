package com.capgemini.boardgames.service;

import com.capgemini.boardgames.repository.HistoryLogsRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryLogsService {

    private HistoryLogsRepositoryImpl historyLogsRepository;

    public List getUserHistoryLogs(long userId) {
        return historyLogsRepository.getUserLogs(userId);
    }
}

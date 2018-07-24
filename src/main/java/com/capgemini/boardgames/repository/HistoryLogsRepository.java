package com.capgemini.boardgames.repository;

import java.util.List;

public interface HistoryLogsRepository {

    List getUserLogs(long userId);
}

package com.capgemini.boardgames.repository;

import java.util.List;

public interface StatisticsRepository {

    List getUserLogs(long userId);

    List getGameLogs(long gameId);
}

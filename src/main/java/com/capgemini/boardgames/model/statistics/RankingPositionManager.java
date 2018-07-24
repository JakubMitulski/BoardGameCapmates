package com.capgemini.boardgames.model.statistics;

import com.capgemini.boardgames.model.GameLogEntry;

import java.util.*;

public class RankingPositionManager {

    public long getRankingPosition(List<GameLogEntry> gameLogs, long userId) {
        Map<Long, Long> map = new HashMap<>();
        List<UserRankingResultObj> resultList = new ArrayList<>();

        for (GameLogEntry log : gameLogs) {
            long playerId = log.getUserId();
            long result = log.getResult();

            if (map.containsKey(playerId)) {
                long oldResult = map.get(playerId);
                long newResult = oldResult + result;
                map.replace(userId, oldResult, newResult);
            } else {
                map.put(playerId, result);
            }
        }


        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            resultList.add(new UserRankingResultObj(entry.getKey(), entry.getValue()));
        }


        RankingResultComparator resultComparator = new RankingResultComparator();
        Collections.sort(resultList, resultComparator);

        return (resultList
                .indexOf(resultList
                        .stream()
                        .filter(userResult -> userResult.getUserId() == userId)
                        .findAny().get())) + 1;

    }
}


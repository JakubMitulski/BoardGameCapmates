package com.capgemini.boardgames.model.statistics;

import java.util.Comparator;

class RankingResultComparator implements Comparator<UserRankingResultObj> {

    @Override
    public int compare(UserRankingResultObj o1, UserRankingResultObj o2) {
        return Math.toIntExact(o2.getUserGameResult() - o1.getUserGameResult());
    }
}

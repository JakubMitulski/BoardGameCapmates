package com.capgemini.boardgames.model.statistics;

import java.io.Serializable;
import java.util.Comparator;

class RankingResultComparator implements Comparator<UserRankingResultObj>, Serializable {

    @Override
    public int compare(UserRankingResultObj o1, UserRankingResultObj o2) {
        return Math.toIntExact(o2.getUserGameResult() - o1.getUserGameResult());
    }
}

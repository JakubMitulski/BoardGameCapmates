package com.capgemini.boardgames.model.statistics;

import java.util.Comparator;

class ResultComparator implements Comparator<UserResultObj> {

    @Override
    public int compare(UserResultObj o1, UserResultObj o2) {
        return Math.toIntExact(o2.getUserGameResult() - o1.getUserGameResult());
    }
}

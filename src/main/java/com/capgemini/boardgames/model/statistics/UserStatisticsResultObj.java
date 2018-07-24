package com.capgemini.boardgames.model.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserStatisticsResultObj {

    private String gameName;
    private long gameRankingPosition;
    private UserLevel gameLevel;
}

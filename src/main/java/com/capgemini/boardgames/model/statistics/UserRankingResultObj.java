package com.capgemini.boardgames.model.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRankingResultObj {

    private long userId;
    private long userGameResult;
}

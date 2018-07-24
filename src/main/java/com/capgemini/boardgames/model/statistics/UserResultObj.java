package com.capgemini.boardgames.model.statistics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResultObj {

    private long userId;
    private long userGameResult;
}

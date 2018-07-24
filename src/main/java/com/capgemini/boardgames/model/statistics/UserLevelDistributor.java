package com.capgemini.boardgames.model.statistics;

public class UserLevelDistributor {

    public UserLevel getLevel(long overallResult){

        if (overallResult > 500){
            return UserLevel.MASTER;
        }
        if (overallResult > 100){
            return UserLevel.PROFESSIONAL;
        }
        if (overallResult > 50){
            return UserLevel.ADVANCED;
        }
        if (overallResult > 10){
            return UserLevel.MEDIUM;
        }
        return UserLevel.BEGGINER;
    }
}

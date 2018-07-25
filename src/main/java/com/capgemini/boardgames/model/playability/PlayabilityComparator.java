package com.capgemini.boardgames.model.playability;

import java.time.LocalTime;

public class PlayabilityComparator {

    public boolean compare(Playability firstPlayability, Playability secondPlayability){

        LocalTime firstPlayerStartTime = firstPlayability.getStartTime();
        LocalTime firstPlayerEndTime = firstPlayability.getEndTime();
        LocalTime secondPlayerStartTime = secondPlayability.getStartTime();
        LocalTime secondPlayerEndTime = secondPlayability.getEndTime();

        if (firstPlayerStartTime.compareTo(secondPlayerEndTime) < 0){
            return firstPlayerEndTime.compareTo(secondPlayerStartTime) > 0;
        }
        return false;
    }
}

package com.capgemini.boardgames.model.playability;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

public class PlayabilityComparator {

    private LocalTime firstPlayerStartTime;
    private LocalTime firstPlayerEndTime;
    private LocalTime secondPlayerStartTime;
    private LocalTime secondPlayerEndTime;

    public boolean compare(Playability firstPlayability, Playability secondPlayability) {

        firstPlayerStartTime = firstPlayability.getStartTime();
        firstPlayerEndTime = firstPlayability.getEndTime();
        secondPlayerStartTime = secondPlayability.getStartTime();
        secondPlayerEndTime = secondPlayability.getEndTime();

        if (firstPlayerStartTime.compareTo(secondPlayerEndTime) < 0) {
            if (firstPlayerEndTime.compareTo(secondPlayerStartTime) > 0) {
                return isTimeDifferenceBigEnough();
            }
        }
        return false;
    }

    private boolean isTimeDifferenceBigEnough() {
        return MINUTES.between(secondPlayerStartTime, firstPlayerEndTime) > 29 ||
                MINUTES.between(firstPlayerStartTime, secondPlayerEndTime) > 29;
    }
}

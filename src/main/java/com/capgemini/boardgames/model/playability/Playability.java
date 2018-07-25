package com.capgemini.boardgames.model.playability;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;


@Getter
@Setter
public class Playability {

    private LocalTime startTime;
    private LocalTime endTime;
    private String message;

    public Playability() {
        this.startTime = LocalTime.parse("00:00");
        this.endTime = LocalTime.parse("00:00");
        this.message = "";
    }

    public Playability(LocalTime startTime, LocalTime endTime, String message) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.message = message;
    }
}
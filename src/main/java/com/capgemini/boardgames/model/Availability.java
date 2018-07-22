package com.capgemini.boardgames.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
public class Availability {

    private Time startTime;
    private Time endTime;
}
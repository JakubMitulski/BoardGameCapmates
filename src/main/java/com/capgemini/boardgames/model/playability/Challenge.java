package com.capgemini.boardgames.model.playability;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Challenge {

    private long owner;
    private long opponent;
}

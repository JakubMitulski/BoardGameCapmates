package com.capgemini.boardgames.model.games;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Monopoly implements Game {

    private List subscribersList;

    public Monopoly() {
        this.subscribersList = new ArrayList();
    }

    @Override
    public List getSubscribersList() {
        return this.subscribersList;
    }

    @Override
    public void removeSubscriber(int userId) {
        this.subscribersList.remove(userId);
    }

    @Override
    public void addSubscriber(int userId) {
        this.subscribersList.add(userId);
    }
}
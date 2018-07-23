package com.capgemini.boardgames.model.games;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Chess implements Game {

    private List subscribersList;

    public Chess() {
        this.subscribersList = new ArrayList();
    }

    @Override
    public List getSubscribersList() {
        return this.subscribersList;
    }

    @Override
    public void removeSubscriber(String email) {
        this.subscribersList.remove(email);
    }

    @Override
    public void addSubscriber(String email) {
        this.subscribersList.add(email);
    }
}

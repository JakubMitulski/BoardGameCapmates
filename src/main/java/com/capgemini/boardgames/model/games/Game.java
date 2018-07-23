package com.capgemini.boardgames.model.games;

import java.util.List;

public interface Game {

    List getSubscribersList();

    void removeSubscriber(String email);

    void addSubscriber(String email);
}

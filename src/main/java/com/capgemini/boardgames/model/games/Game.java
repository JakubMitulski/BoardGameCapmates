package com.capgemini.boardgames.model.games;

import java.util.List;

public interface Game {

    List getSubscribersList();

    void removeSubscriber(int userId);

    void addSubscriber(int userId);
}

package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.games.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class GameRepositoryImpl implements GameRepository {

    @Autowired
    private Set<Game> gamesCollection;

    public GameRepositoryImpl() {
        gamesCollection.add(new Battleship());
        gamesCollection.add(new Chess());
        gamesCollection.add(new Monopoly());
        gamesCollection.add(new Scrabble());
    }

    public List<Game> getUserGames(Integer userId) {
        return gamesCollection
                .stream()
                .filter(game -> game.getSubscribersList()
                        .stream()
                        .allMatch(id -> id == userId))
                .collect(Collectors.toList());
    }

    public void addGame(Game game, Integer userId) {
        game.addSubscriber(userId);
    }

    public void removeGame(Game game, Integer userId) {
        game.removeSubscriber(userId);
    }
}

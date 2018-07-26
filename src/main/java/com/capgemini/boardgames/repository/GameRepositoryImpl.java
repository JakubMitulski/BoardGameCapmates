package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.Game;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class GameRepositoryImpl implements GameRepository {

    private Set<Game> gamesCollection;
    public static final AtomicLong counter = new AtomicLong(1);

    public GameRepositoryImpl() {
        gamesCollection = new HashSet<>();
        this.gamesCollection.add(new Game(counter.getAndIncrement(), "Battleship", 2, 2));
        this.gamesCollection.add(new Game(counter.getAndIncrement(), "Chess", 2, 2));
        this.gamesCollection.add(new Game(counter.getAndIncrement(), "Monopoly", 2, 4));
        this.gamesCollection.add(new Game(counter.getAndIncrement(), "Scrabble", 2, 4));
    }

    @Override
    public List<Game> getUserGames(long userId) {
        List<Game> userGames = new ArrayList<>();

        for (Game game : gamesCollection) {
            Optional<Long> optionalId = game.getSubscribersList().stream().filter(id -> id == userId).findAny();

            if (optionalId.isPresent()) {
                userGames.add(game);
            }
        }
        return userGames;
    }

    @Override
    public Game findGameByName(String gameName) {
        Optional<Game> optionalGame = gamesCollection
                .stream()
                .filter(game -> game.getName() == gameName)
                .findAny();

        if (optionalGame.isPresent()) {
            return optionalGame.get();
        }
        return null;
    }

    @Override
    public void addGame(String gameName, long userId) {
        findGameByName(gameName).getSubscribersList().add(userId);
    }

    @Override
    public void removeGame(String gameName, long userId) {
        findGameByName(gameName).getSubscribersList().remove(userId);
    }

    @Override
    public void addNewGameToGamesCollection(Game game) {
        gamesCollection.add(game);
    }

    @Override
    public List<Long> getUsersWithSpecifiedGame(String gameName) {
        return findGameByName(gameName).getSubscribersList();
    }
}

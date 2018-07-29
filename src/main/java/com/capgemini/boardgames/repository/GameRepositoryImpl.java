package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.Game;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class GameRepositoryImpl implements GameRepository {

    private Set<Game> gamesCollection;
    public static final AtomicLong counter = new AtomicLong(1);

    public GameRepositoryImpl() {
        gamesCollection = new HashSet<>();

        Game battleship = new Game(counter.getAndIncrement(), "Battleship", 2, 2);
        ArrayList<Long> subs = new ArrayList<>();
        subs.add(1L);
        subs.add(2L);
        battleship.setSubscribersList(subs);
        this.gamesCollection.add(battleship);

        Game chess = new Game(counter.getAndIncrement(), "Chess", 2, 2);
        ArrayList<Long> subs2 = new ArrayList<>();
        subs2.add(1L);
        chess.setSubscribersList(subs2);
        this.gamesCollection.add(chess);

        this.gamesCollection.add(new Game(counter.getAndIncrement(), "Monopoly", 2, 4));
        this.gamesCollection.add(new Game(counter.getAndIncrement(), "Scrabble", 4, 4));
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
    public Game getGameByName(String gameName) {
        Optional<Game> optionalGame = gamesCollection
                .stream()
                .filter(game -> game.getName().equals(gameName))
                .findAny();

        return optionalGame.orElse(null);
    }

    @Override
    public void addGame(String gameName, long userId) {
        getGameByName(gameName).getSubscribersList().add(userId);
    }

    @Override
    public void removeGame(String gameName, long userId) {
        getGameByName(gameName).getSubscribersList().remove(userId);
    }

    @Override
    public void addNewGameToGamesCollection(Game game) {
        gamesCollection.add(game);
    }

    @Override
    public List<Long> getUsersWithSpecifiedGame(String gameName) {
        return getGameByName(gameName).getSubscribersList();
    }

    @Override
    public boolean checkIfGamesCollectionContainsGame(String gameName) {
        return gamesCollection.stream().anyMatch(game -> game.getName() == gameName);
    }

    @Override
    public List<Game> getGameByMinPlayersNumber(Integer minPlayersNumber) {
        return gamesCollection.stream().filter(game -> game.getMinPlayerNumber() >= minPlayersNumber).collect(Collectors.toList());
    }

    @Override
    public List<Game> getGameByMaxPlayersNumber(Integer maxPlayerNumber) {
        return gamesCollection.stream().filter(game -> game.getMaxPlayerNumber() <= maxPlayerNumber).collect(Collectors.toList());
    }

    @Override
    public List<Game> getGamesOfSubscribers(List<Long> playersList) {
        List<Game> result = new ArrayList<>();

        for (Game game : gamesCollection) {
            if (game.getSubscribersList().containsAll(playersList)) {
                result.add(game);
            }
        }

        return result;
    }
}

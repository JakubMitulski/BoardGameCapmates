package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.Game;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class GameRepositoryImpl implements GameRepository {

    private Set<Game> gamesCollection;

    public GameRepositoryImpl() {
        gamesCollection = new HashSet<>();
        this.gamesCollection.add(new Game(1, "Battleship", 2, 2));
        this.gamesCollection.add(new Game(2, "Chess", 2, 2));
        this.gamesCollection.add(new Game(3, "Monopoly", 2, 4));
        this.gamesCollection.add(new Game(4, "Scrabble", 2, 4));
    }

    @Override
    public List<Game> getUserGames(long userId) {
        return gamesCollection
                .stream()
                .filter(game -> game.getSubscribersList()
                        .stream()
                        .allMatch(id -> id == userId))
                .collect(Collectors.toList());
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
}

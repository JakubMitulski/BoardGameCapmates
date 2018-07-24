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

    public List<Game> getUserGames(String userEmail) {
        return gamesCollection
                .stream()
                .filter(game -> game.getSubscribersList()
                        .stream()
                        .allMatch(email -> email == userEmail))
                .collect(Collectors.toList());
    }

    public Game findGameByName(String gameName){
        Optional<Game> optionalGame = gamesCollection
                .stream()
                .filter(game -> game.getName() == gameName)
                .findAny();

        if (optionalGame.isPresent()){
            return optionalGame.get();
        }
        return null;
    }

    public void addGame(String gameName, String email) {
        findGameByName(gameName).getSubscribersList().add(email);
    }

    public void removeGame(String gameName, String email) {
        findGameByName(gameName).getSubscribersList().remove(email);
    }

    @Override
    public void addNewGameToGamesCollection(Game game) {
        gamesCollection.add(game);
    }
}

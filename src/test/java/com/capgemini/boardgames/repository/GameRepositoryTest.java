package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.Game;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Test
    public void shouldReturnListOfUserGamesByGivenUserId() {
        //When
        gameRepository.addGame("Monopoly", 6);
        List<Game> userGames = gameRepository.getUserGames(6);

        //Then
        assertEquals(1, userGames.size());
        assertEquals("Monopoly", userGames.get(0).getName());
    }

    @Test
    public void shouldReturnGameObjectWhenFindGameByNameMethodCall(){
        //When
        Game chess = gameRepository.getGameByName("Chess");

        //Then
        assertEquals("Chess", chess.getName());
    }

    @Test
    public void shouldAddSpecifiedGameToUserGames(){
        //When
        gameRepository.addGame("Scrabble", 4);
        List<Game> userGames = gameRepository.getUserGames(4);

        //Then
        assertEquals(1, userGames.size());
        assertEquals("Scrabble", userGames.get(0).getName());
    }

    @Test
    public void shouldRemoveSpecifiedGameFromUserGames(){
        //When
        gameRepository.addGame("Scrabble", 5);
        gameRepository.removeGame("Scrabble", 5);
        List<Game> userGames = gameRepository.getUserGames(5);

        //Then
        assertEquals(0, userGames.size());
    }

    @Test
    public void shouldAddNewGameToGamesCollection(){
        //When
        gameRepository.addNewGameToGamesCollection(new Game(5, "Cards", 1, 5));
        Game cards = gameRepository.getGameByName("Cards");

        //Then
        assertEquals("Cards", cards.getName());
    }

    @Test
    public void shouldGetListOfUsersWhoOwnedSpecifiedGameInCollection(){
        //When
        gameRepository.addGame("Monopoly", 1);
        gameRepository.addGame("Monopoly", 2);
        gameRepository.addGame("Monopoly", 3);
        List<Long> battleship = gameRepository.getUsersWithSpecifiedGame("Monopoly");

        //Then
        assertEquals(3, battleship.size());
    }
}

package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.model.Game;
import com.capgemini.boardgames.repository.GameRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Autowired
    GameRepository gameRepository;

    @Test
    public void shouldReturnGamesFromUserGamesList() {
        //When
        List games = gameService.getGamesFromUserGamesList(6);

        //Then
        assertEquals(0, games.size());
    }

    @Test
    public void shouldRemoveSpecifiedGameFromUserGames() {
        //When
        gameService.addGameToUserGameList("Monopoly", 5);
        gameService.removeGameFromUserGameList("Monopoly", 5);
        List games = gameService.getGamesFromUserGamesList(5);

        //Then
        assertEquals(0, games.size());
    }

    @Test
    public void shouldAddSpecifiedGameFromUserGames() {
        //When
        gameService.addGameToUserGameList("Monopoly", 2);
        List<Game> games = gameRepository.getUserGames(2);

        //Then
        Game resultGame = games.stream().filter(game -> game.getName() == "Monopoly").findAny().get();
        assertEquals("Monopoly", resultGame.getName());
    }

    @Test
    public void shouldAddNewGameToOverallGameCollection() {
        //Given
        GameDto gameDto = new GameDto(6, "Test", 2, 2);

        //When
        gameService.addNewGameToSystem(gameDto);
        gameService.addGameToUserGameList("Test", 4);
        List<Game> userGames = gameRepository.getUserGames(4);

        //Then
        assertEquals("Test", userGames.stream().filter(game -> game.getName() == "Test").findAny().get().getName());
    }


}

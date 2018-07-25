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
        gameRepository.addGame("Monopoly", 4);
        List<Game> userGames = gameRepository.getUserGames(4);

        //Then
        assertEquals(1, userGames.size());
        assertEquals("Monopoly", userGames.get(0).getName());

    }
}

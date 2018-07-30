package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.dto.GameLogEntryDto;
import com.capgemini.boardgames.model.statistics.UserLevel;
import com.capgemini.boardgames.model.statistics.UserStatisticsResultObj;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsServiceTest {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private GameService gameService;

    @Test
    public void shouldGetUserGamesHistory() {
        //When
        List<GameLogEntryDto> history = statisticsService.getUserGamesHistory(1);

        //Then
        assertEquals(3, history.size());
    }

    @Test
    public void shouldGetUserRankingPositionInSpecificGame() {
        //When
        long rankingPosU1 = statisticsService.getUserRankingPos(1, 1);
        long rankingPosU4 = statisticsService.getUserRankingPos(1, 4);

        //Then
        assertEquals(1, rankingPosU1);
        assertEquals(4, rankingPosU4);
    }

    @Test
    public void shouldGetUserLevelInSpecifiedGame() {
        //When
        UserLevel userLevel = statisticsService.getUserLevel(1, 1);

        //Then
        assertEquals(UserLevel.MEDIUM, userLevel);
    }

    @Test
    public void shouldReturnUserStatistics() {
        //Given
        GameDto gameDto1 = new GameDto(1, "Battleship", 2, 2);
        GameDto gameDto3 = new GameDto(3, "Monopoly", 2, 2);

        //When
        gameService.addGameToUserGameList(gameDto1, 7);
        gameService.addGameToUserGameList(gameDto3, 7);
        List<UserStatisticsResultObj> statistics = statisticsService.getUserStatistics(7);

        //Then
        assertEquals(2, statistics.size());
    }
}

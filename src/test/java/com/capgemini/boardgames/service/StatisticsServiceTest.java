package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.statistics.GameLogEntry;
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
    public void shouldGetUserGamesHistory(){
        //When
        List<GameLogEntry> history = statisticsService.getUserGamesHistory(1);

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
        assertEquals(3, rankingPosU4);
    }

    @Test
    public void shouldGetUserLevelInSpecifiedGame(){
        //When
        UserLevel userLevel = statisticsService.getUserLevel(1, 1);

        //Then
        assertEquals(UserLevel.MEDIUM, userLevel);
    }

    @Test
    public void shouldReturnUserStatistics(){
        //When
        gameService.addGameToUserGameList("Monopoly", 1);
        gameService.addGameToUserGameList("Battleship", 1);
        List<UserStatisticsResultObj> statistics = statisticsService.getUserStatistics(1);

        //Then
        assertEquals(2, statistics.size());
    }


}

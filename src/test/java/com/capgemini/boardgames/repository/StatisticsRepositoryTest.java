package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.statistics.GameLogEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsRepositoryTest {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Test
    public void shouldReturnSpecifiedUserHistoryLogs(){
        //When
        List<GameLogEntry> userLogs = statisticsRepository.getUserLogs(1);

        //Then
        assertEquals(3, userLogs.size());
    }

    @Test
    public void shouldReturnSpecifiedGameHistoryLogs(){
        //When
        List<GameLogEntry> gameLogs = statisticsRepository.getGameLogs(3);

        //Then
        assertEquals(4, gameLogs.size());
    }

}

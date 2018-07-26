package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.User;
import com.capgemini.boardgames.model.playability.Challenge;
import com.capgemini.boardgames.repository.GameRepository;
import com.capgemini.boardgames.repository.StatisticsRepository;
import com.capgemini.boardgames.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayabilityServiceTest {

    @Autowired
    private PlayabilityService playabilityService;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void shouldAddUserPlayabilityHours() {
        //When
        playabilityService.addUserPlayabilityHours(1, "12:00", "15:00");
        User user = userRepository.findById(1);

        //Then
        assertEquals(LocalTime.parse("12:00"), user.getPlayability().getStartTime());
    }

    @Test
    public void shouldEditUserPlayabilityHours() {
        //When
        playabilityService.editUserPlayabilityHours(1, "11:00", "15:00", "Edited");
        User user = userRepository.findById(1);

        //Then
        assertEquals("Edited", user.getPlayability().getMessage());
    }

    @Test
    public void shouldRemoveUserPlayabilityHours() {
        //When
        playabilityService.removeUserPlayabilityHours(1, "Removed");
        User user = userRepository.findById(1);

        //Then
        assertEquals("Removed", user.getPlayability().getMessage());
    }


    //START WITH ALL com.capgemini.boardgames TESTS!!!
    @Test
    public void shouldReturnListOfUsersWithSimilarPlayabilityHoursAndCreateChallenge(){
        //When
        playabilityService.addUserPlayabilityHours(1, "12:00", "15:00");
        playabilityService.addUserPlayabilityHours(2, "13:00", "16:00");
        playabilityService.addUserPlayabilityHours(4, "16:30", "18:00");
        List list = playabilityService.getUsersWithSimilarPlayability(1, "Battleship");
        Challenge challenge = playabilityService.createChallenge(1, list);

        //Then
        assertEquals(1, list.size());
        assertEquals(2, challenge.getOpponent());
    }
}

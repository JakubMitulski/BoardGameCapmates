package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.User;
import com.capgemini.boardgames.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayabilityServiceTest {

    @Autowired
    private PlayabilityService playabilityService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldAddUserPlayabilityHours(){
        //When
        playabilityService.addUserPlayabilityHours(1, "12:00", "15:00");
        User user = userRepository.findById(1);

        //Then
        assertEquals(LocalTime.parse("12:00"), user.getPlayability().getStartTime());
    }


}

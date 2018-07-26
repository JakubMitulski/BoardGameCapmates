package com.capgemini.boardgames.aop;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.model.playability.Playability;
import com.capgemini.boardgames.repository.UserRepository;
import com.capgemini.boardgames.service.UserProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AspectServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileService userProfileService;

    @Test
    public void shouldTest() {
        userRepository.findById(1);
    }

    @Test
    public void shouldValidate() {
       // userProfileService.editUserProfile(new UserDto(5, "Stefan", "Stefanowicz", "Witam", "stefan@mail.com", "admin", new Playability()));
    }
}
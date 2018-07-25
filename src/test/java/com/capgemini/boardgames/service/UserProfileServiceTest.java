package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.model.playability.Playability;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProfileServiceTest {

    @Autowired
    private UserProfileService userProfileService;

    @Test
    public void shouldFindUserProfileByEmailAndReturnDto() {
        //When
        UserDto userDto = userProfileService.getUserProfileByEmail("1@mail.com");

        //Then
        assertEquals(1, userDto.getId());
    }

    @Test
    public void shouldFindUserProfileByIdAndReturnDto() {
        //When
        UserDto userDto = userProfileService.getUserProfileById(5);

        //Then
        assertEquals("Test", userDto.getFirstname());
    }

    @Test
    public void shouldEditUserProfileAndReturnDto() {
        //Given
        UserDto userDto = new UserDto(5, "Stefan", "Stefanowicz", "Witam", "stefan@mail.com", "admin", new Playability());

        //When
        userProfileService.editUserProfile(userDto);
        UserDto user = userProfileService.getUserProfileById(5);

        //Then
        assertEquals("Stefan", user.getFirstname());
    }
}

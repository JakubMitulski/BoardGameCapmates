package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.exception.NoSuchUserException;
import com.capgemini.boardgames.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnCorrectUserWhenFindByEmailMethodCall() {
        //When
        long userId = userRepository.findByEmail("2@mail.com").getId();

        //Then
        assertEquals(2, userId);
    }

    @Test
    public void shouldReturnCorrectUserWhenFindByIdMethodCall() throws NoSuchUserException {
        //When
        String lastname = userRepository.findById(3).getLastname();

        //Then
        assertEquals("Mariusz", lastname);
    }

    @Test
    public void shouldUpdateUserWhenUpdateMethodCall() throws NoSuchUserException {
        //Given
        UserDto userDto = new UserDto(2, "Janusz", "Nowak", "My motto has changed", "2@mail.com", "password");

        //When
        userRepository.update(userDto);
        User userAfterUpdate = userRepository.findById(userDto.getId());

        //Then
        assertEquals("My motto has changed", userAfterUpdate.getMotto());
    }
}

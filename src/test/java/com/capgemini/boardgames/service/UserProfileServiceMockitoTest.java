package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.exception.NoSuchUserException;
import com.capgemini.boardgames.mapper.UserDtoMapper;
import com.capgemini.boardgames.model.playability.Playability;
import com.capgemini.boardgames.repository.UserRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProfileServiceMockitoTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserDtoMapper userDtoMapper;

    @InjectMocks
    UserProfileService userProfileService;

    private static UserDto userDto;
    private final long expectedId = 1L;

    @BeforeClass
    public static void init() {
        userDto = new UserDto(1, "Jan", "Kowalski", "I like boardgames", "1@mail.com", "password");
    }

    @Before
    public void setUp() throws NoSuchUserException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(userProfileService.getUserProfileById(1)).thenReturn(userDto);
        Mockito.when(userDtoMapper.map(userRepository.findById(1))).thenReturn(userDto);
    }


    @Test
    public void shouldFindUserProfileByIdAndReturnDto() throws NoSuchUserException {
        //When
        UserDto userDto = userProfileService.getUserProfileById(expectedId);

        //Then
        assertEquals(expectedId, userDto.getId());
    }

}

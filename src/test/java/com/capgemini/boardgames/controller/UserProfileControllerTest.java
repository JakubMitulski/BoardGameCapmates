package com.capgemini.boardgames.controller;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.service.UserProfileService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserProfileControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private UserProfileService userProfileService;

    @Autowired
    private UserProfileController userProfileController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(userProfileService);
        Mockito.reset(userProfileService);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        ReflectionTestUtils.setField(userProfileController, "userProfileService", userProfileService);
    }

    @Test
    public void shouldReturnProperUserProfile() throws Exception {
        //Given
        UserDto userDto = new UserDto(1, "Jan", "Kowalski", "I like boardgames", "1@mail.com", "password");
        Mockito.when(userProfileService.getUserProfileById(1)).thenReturn(userDto);

        //When
        ResultActions resultActions = mockMvc.perform(get("http://localhost:9000/user/1"));

        //Then
        resultActions.andExpect(status().isOk()).andExpect(jsonPath("firstname").value("Jan"));
        verify(userProfileService, times(1)).getUserProfileById(Mockito.anyLong());
    }

    @Test
    public void shouldEditUserProfile() throws Exception {
        //Given
        String json = "{\"id\":1,\"firstname\":\"Jan\",\"lastname\":\"Kowalski\",\"motto\":\"I like boardgames\",\"email\":\"1@mail.com\",\"password\":\"password\",\"playability\":{\"startTime\":\"00:00:00\",\"endTime\":\"00:00:00\",\"message\":\"\"}}";

        //When
        ResultActions resultActions = mockMvc.perform(put("http://localhost:9000/user")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json));

        //Then
        resultActions.andExpect(status().isOk());
        verify(userProfileService, times(1)).editUserProfile(Mockito.any(UserDto.class));
    }
}


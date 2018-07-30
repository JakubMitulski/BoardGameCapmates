package com.capgemini.boardgames.controller;

import com.capgemini.boardgames.dto.GameByRequestDTO;
import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.service.GameService;
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

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class GameControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private GameService gameService;

    @Autowired
    private GameController gameController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(gameService);
        Mockito.reset(gameService);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        ReflectionTestUtils.setField(gameController, "gameService", gameService);
    }

    @Test
    public void shouldGetRequestByParams() throws Exception {
        // given
        String json = "{\"minPlayersNumber\":2,\"maxPlayersNumber\":2,\"subscribersList\":[1,2]}";

        GameByRequestDTO gameByRequestDTO = new GameByRequestDTO();
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        gameByRequestDTO.setMinPlayersNumber(2);
        gameByRequestDTO.setMaxPlayersNumber(2);
        gameByRequestDTO.setSubscribersList(list);

        GameDto battleship = new GameDto();
        battleship.setId(1);
        battleship.setName("Battleship");
        battleship.setMaxPlayerNumber(2);
        battleship.setMinPlayerNumber(2);
        battleship.setSubscribersList(list);

        ArrayList<GameDto> resultList = new ArrayList<>();
        resultList.add(battleship);

        // when
        Mockito.when(gameService.findGamesByParams(Mockito.any())).thenReturn(resultList);

        ResultActions resultActions = mockMvc.perform(put("http://localhost:9000/games")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json));

        // then
        resultActions.andExpect(status().isOk()).andExpect(jsonPath("$[0].name").value("Battleship"));
    }
}

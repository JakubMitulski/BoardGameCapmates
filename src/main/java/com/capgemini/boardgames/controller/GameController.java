package com.capgemini.boardgames.controller;

import com.capgemini.boardgames.dto.GameByRequestDTO;
import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.service.GameService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PutMapping(path = "/games", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List> findGamesByParams(@RequestBody GameByRequestDTO gameByRequestDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        List<GameDto> gamesList = gameService.findGamesByParams(gameByRequestDTO);

        return ResponseEntity.ok(gamesList);
    }
}

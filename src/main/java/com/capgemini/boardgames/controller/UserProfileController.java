package com.capgemini.boardgames.controller;

import com.capgemini.boardgames.dto.GameByRequestDTO;
import com.capgemini.boardgames.dto.GameDto;
import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.service.GameService;
import com.capgemini.boardgames.service.UserProfileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final GameService gameService;

    public UserProfileController(UserProfileService userProfileService, GameService gameService) {
        this.userProfileService = userProfileService;
        this.gameService = gameService;
    }

    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDto> getUserProfileById(@PathVariable Long id) {
        UserDto userDto = userProfileService.getUserProfileById(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDto> updateOwner(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        userProfileService.editUserProfile(userDto);
        return ResponseEntity.ok(userDto);
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

package com.capgemini.boardgames.controller;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.exception.NoSuchUserException;
import com.capgemini.boardgames.service.UserProfileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UserProfileController {

    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping(path = "/user/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDto> getUserProfileById(@PathVariable Long id) throws NoSuchUserException {
        UserDto userDto = userProfileService.getUserProfileById(id);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping(path = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDto> editUserProfile(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) throws NoSuchUserException {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        userProfileService.editUserProfile(userDto);
        return ResponseEntity.ok(userDto);
    }
}

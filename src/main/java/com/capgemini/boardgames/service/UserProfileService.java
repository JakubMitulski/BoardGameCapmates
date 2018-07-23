package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.model.User;

public interface UserProfileService {

    UserDto showUserProfile(String email);

    UserDto editUserProfile(User user);

    void saveUserProfile(UserDto userDto);
}
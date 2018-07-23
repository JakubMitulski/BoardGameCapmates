package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.model.User;

public interface UserProfileService {

    UserDto getUserProfile(String email);

    User editUserProfile(UserDto userDto);
}
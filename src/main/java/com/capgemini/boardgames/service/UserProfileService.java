package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.model.User;

public interface UserProfileService {

    UserDto showUserProfile(User user);

    User editUserProfile(User user);

    void saveUserProfile(User user);
}
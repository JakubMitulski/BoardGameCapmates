package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.User;

public interface ProfileService {

    void showUserProfile(User user);

    User editUserProfile(User user);

    void saveUserProfile(User user);
}
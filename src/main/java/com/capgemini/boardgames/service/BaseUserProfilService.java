package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.model.User;
import com.capgemini.boardgames.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class BaseUserProfilService implements UserProfileService {

    private UserRepository userRepository;

    public BaseUserProfilService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto showUserProfile(User user) {
        return userRepository.show(user);
    }

    @Override
    public User editUserProfile(User user) {
        return null;
    }

    @Override
    public void saveUserProfile(User user) {

    }
}

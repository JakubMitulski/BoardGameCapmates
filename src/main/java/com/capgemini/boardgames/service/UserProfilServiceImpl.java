package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.mapper.UserToUserDtoMapper;
import com.capgemini.boardgames.model.User;
import com.capgemini.boardgames.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserProfilServiceImpl implements UserProfileService {

    private UserRepository userRepository;

    public UserProfilServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto showUserProfile(String email) {
        return new UserToUserDtoMapper().map(userRepository.findByEmail(email));
    }

    @Override
    public UserDto editUserProfile(User user) {
        UserDto userDto = new UserToUserDtoMapper().map(userRepository.findByEmail(user.getEmail()));
        userDto.setEmail(user.getEmail());
        userDto.setMotto(user.getMotto());
        userDto.setAvailability(user.getAvailability());
        return userDto;
    }

    @Override
    public void saveUserProfile(UserDto userDto) {
        userRepository.save(userRepository.findByEmail(userDto.getEmail()));
    }
}

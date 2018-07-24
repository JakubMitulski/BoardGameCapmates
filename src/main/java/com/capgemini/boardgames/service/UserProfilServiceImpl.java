package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.mapper.UserToUserDtoMapper;
import com.capgemini.boardgames.model.User;
import com.capgemini.boardgames.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfilServiceImpl implements UserProfileService {

    private UserRepository userRepository;

    @Autowired
    private UserToUserDtoMapper userToUserDtoMapper;

    public UserProfilServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserProfile(String email) {
        return userToUserDtoMapper.map(userRepository.findByEmail(email));
    }

    @Override
    public User editUserProfile(UserDto userDto) {
        User user = userRepository.findById(userDto.getId());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setMotto(userDto.getMotto());
        user.setAvailability(userDto.getAvailability());
        return user;
    }
}

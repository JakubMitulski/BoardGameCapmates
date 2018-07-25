package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.mapper.UserToUserDtoMapper;
import com.capgemini.boardgames.model.User;
import com.capgemini.boardgames.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private UserRepository userRepository;

    @Autowired
    private UserToUserDtoMapper userToUserDtoMapper;


    public UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDto getUserProfileByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return userToUserDtoMapper.map(user);
    }


    public UserDto getUserProfileById(long id) {
        return userToUserDtoMapper.map(userRepository.findById(id));
    }


    public User editUserProfile(UserDto userDto) {
        User user = userRepository.findById(userDto.getId());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setMotto(userDto.getMotto());
        user.setPlayability(userDto.getPlayability());
        return user;
    }
}

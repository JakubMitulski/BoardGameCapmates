package com.capgemini.boardgames.service;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.exception.NoSuchUserException;
import com.capgemini.boardgames.mapper.UserDtoMapper;
import com.capgemini.boardgames.model.User;
import com.capgemini.boardgames.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private UserRepository userRepository;

    @Autowired
    private UserDtoMapper userDtoMapper;


    public UserProfileService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDto getUserProfileByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return userDtoMapper.map(user);
    }


    public UserDto getUserProfileById(long id) throws NoSuchUserException {
        return userDtoMapper.map(userRepository.findById(id));
    }


    public void editUserProfile(UserDto userDto) throws NoSuchUserException {
        User user = userRepository.findById(userDto.getId());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setMotto(userDto.getMotto());
        user.setPassword(userDto.getPassword());
        user.setPlayability(userDto.getPlayability());
    }
}

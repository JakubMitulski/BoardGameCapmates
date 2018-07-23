package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.mapper.UserToUserDtoMapper;
import com.capgemini.boardgames.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> usersList;

    public UserRepository() {
        this.usersList = new ArrayList<>();
    }

    public UserDto show(User user) {
        Optional<User> optionalUser = usersList
                .stream()
                .filter(searchedUser -> searchedUser.getEmail() == user.getEmail()).findAny();

        if (optionalUser.isPresent()){
            return new UserToUserDtoMapper().map(optionalUser.get());
        }
        return null;
    }

    public User edit(User user) {

        return null;
    }

    public void save(User user) {

    }
}

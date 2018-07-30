package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.exception.NoSuchUserException;
import com.capgemini.boardgames.model.User;

public interface UserRepository {

    User findByEmail(String email);

    User findById(long id) throws NoSuchUserException;

    void update(UserDto userDto) throws NoSuchUserException;
}

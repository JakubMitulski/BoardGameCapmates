package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.model.User;

public interface UserRepository {

    User findByEmail(String email);

    User findById(long id);

    void update(UserDto userDto);
}

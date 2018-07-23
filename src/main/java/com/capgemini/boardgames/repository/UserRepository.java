package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.User;

public interface UserRepository {

    User findByEmail(String email);

    User findById(int id);

    void save(User user);
}

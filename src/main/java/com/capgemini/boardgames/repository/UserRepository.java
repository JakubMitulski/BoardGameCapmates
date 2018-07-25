package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.User;

import java.util.List;

public interface UserRepository {

    User findByEmail(String email);

    User findById(long id);

    void update(User user);

    List getUserList();
}

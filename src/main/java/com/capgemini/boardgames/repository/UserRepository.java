package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> usersList;

    public UserRepository() {
        this.usersList = new ArrayList<>();
    }

    public User findByEmail(String email) {
        Optional<User> optionalUser = usersList
                .stream()
                .filter(user -> user.getEmail() == email).findAny();

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    public void save(User user) {

    }
}

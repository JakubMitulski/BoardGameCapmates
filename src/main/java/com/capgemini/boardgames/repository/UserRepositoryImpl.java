package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private List<User> usersList;

    public UserRepositoryImpl() {
        this.usersList = new ArrayList<>();
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> optionalUser = usersList
                .stream()
                .filter(user -> user.getEmail() == email).findAny();

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public User findById(int id) {
        Optional<User> optionalUser = usersList.stream()
                .filter(user -> user.getId() == id)
                .findAny();
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public void save(User user) {
        User userToSave = findById(user.getId());
        userToSave.setEmail(user.getEmail());
        userToSave.setAvailability(user.getAvailability());
        userToSave.setMotto(user.getMotto());
    }
}

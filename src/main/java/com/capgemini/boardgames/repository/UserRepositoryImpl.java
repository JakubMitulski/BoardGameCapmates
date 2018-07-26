package com.capgemini.boardgames.repository;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private List<User> usersList;
    public static final AtomicLong counter = new AtomicLong(1);

    public UserRepositoryImpl() {
        usersList = new ArrayList<>();
        this.usersList.add(new User(counter.getAndIncrement(), "Jan", "Kowalski", "I like boardgames", "1@mail.com"));
        this.usersList.add(new User(counter.getAndIncrement(), "Janusz", "Nowak", "Games are ok", "2@mail.com"));
        this.usersList.add(new User(counter.getAndIncrement(), "Marian", "Mariusz", "Games freak", "3@mail.com"));
        this.usersList.add(new User(counter.getAndIncrement(), "Wacław", "Wacek", "Winner", "4@mail.com"));
        this.usersList.add(new User(counter.getAndIncrement(), "Test", "Testowy", "Test", "test@mail.com"));
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
    public User findById(long id) {
        Optional<User> optionalUser = usersList
                .stream()
                .filter(user -> user.getId() == id)
                .findAny();
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public void update(UserDto userDto) {
        User userToSave = findById(userDto.getId());
        userToSave.setFirstname(userDto.getFirstname());
        userToSave.setLastname(userDto.getLastname());
        userToSave.setEmail(userDto.getEmail());
        userToSave.setPlayability(userDto.getPlayability());
        userToSave.setMotto(userDto.getMotto());
    }
}

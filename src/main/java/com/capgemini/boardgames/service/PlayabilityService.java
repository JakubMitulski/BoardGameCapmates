package com.capgemini.boardgames.service;

import com.capgemini.boardgames.exception.NoSuchUserException;
import com.capgemini.boardgames.model.User;
import com.capgemini.boardgames.model.playability.Challenge;
import com.capgemini.boardgames.model.playability.Playability;
import com.capgemini.boardgames.model.playability.PlayabilityComparator;
import com.capgemini.boardgames.repository.GameRepository;
import com.capgemini.boardgames.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayabilityService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;


    public void addUserPlayabilityHours(long userId, String startTime, String endTime) throws NoSuchUserException {
        LocalTime startHour = LocalTime.parse(startTime);
        LocalTime endHour = LocalTime.parse(endTime);

        userRepository.findById(userId).setPlayability(new Playability(startHour, endHour, ""));
    }


    public void editUserPlayabilityHours(long userId, String startTime, String endTime, String message) throws NoSuchUserException {
        Playability playability = userRepository.findById(userId).getPlayability();
        playability.setStartTime(LocalTime.parse(startTime));
        playability.setEndTime(LocalTime.parse(endTime));
        playability.setMessage(message);
    }


    public void removeUserPlayabilityHours(long userId, String message) throws NoSuchUserException {
        Playability playability = userRepository.findById(userId).getPlayability();
        playability.setStartTime(LocalTime.parse("00:00"));
        playability.setEndTime(LocalTime.parse("00:00"));
        playability.setMessage(message);
    }


    public List<Long> getUsersWithSimilarPlayability(long userId, String gameName) throws NoSuchUserException {

        List<Long> users = gameRepository.getUsersWithSpecifiedGame(gameName);
        Playability userPlayability = userRepository.findById(userId).getPlayability();
        List<Long> usersWithSimilarPlayability = new ArrayList<>();

        for (Long id : users) {
            User otherUser = userRepository.findById(id);
            Boolean isSimilar = new PlayabilityComparator().compare(userPlayability, otherUser.getPlayability());

            if (isSimilar && id != userId) {
                usersWithSimilarPlayability.add(id);
            }
        }
        return usersWithSimilarPlayability;
    }

    public Challenge createChallenge(long userId, List<Long> usersWithSimilarPlayability) {
        int opponentIndex = (int) (Math.random() * (usersWithSimilarPlayability.size() - 1));
        return new Challenge(userId, usersWithSimilarPlayability.get(opponentIndex));
    }
}

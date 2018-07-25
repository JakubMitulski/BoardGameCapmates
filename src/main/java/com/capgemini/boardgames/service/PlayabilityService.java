package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.User;
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


    public void addUserPlayabilityHours(long userId, String startTime, String endTime) {
        LocalTime startHour = LocalTime.parse(startTime);
        LocalTime endHour = LocalTime.parse(endTime);

        userRepository.findById(userId).setPlayability(new Playability(startHour, endHour, ""));
    }


    public void editUserPlayabilityHours(long userId, String startTime, String endTime, String message) {
        Playability playability = userRepository.findById(userId).getPlayability();
        playability.setStartTime(LocalTime.parse(startTime));
        playability.setEndTime(LocalTime.parse(endTime));
        playability.setMessage(message);
    }


    public void removeUserPlayabilityHours(long userId, String message) {
        Playability playability = userRepository.findById(userId).getPlayability();
        playability.setStartTime(LocalTime.parse("0:00"));
        playability.setEndTime(LocalTime.parse("0:00"));
        playability.setMessage(message);
    }


    public List getUsersWithSimilarPlayability(long userId, String gameName) {

        List<Long> users = gameRepository.getUsersWithSpecifiedGame(gameName);
        Playability userPlayability = userRepository.findById(userId).getPlayability();
        List<Long> usersWithSimilarPlayability = new ArrayList<>();

        for (Long id : users) {
            User otherUser = userRepository.findById(id);
            Boolean isSimilar = new PlayabilityComparator().compare(userPlayability, otherUser.getPlayability());

            if (isSimilar) {
                usersWithSimilarPlayability.add(id);
            }
        }
        return usersWithSimilarPlayability;
    }
}

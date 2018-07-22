package com.capgemini.boardgames.service;

import com.capgemini.boardgames.model.Availability;
import com.capgemini.boardgames.model.User;

import java.util.List;

public interface ChallengeService {

    void addAvailabilityHours(Availability availability);

    Availability editAvailabilityHours(Availability availability);

    String removeAvailabilityHours(Availability availability);

    List<User> findUsersByAvailability(User user);

}

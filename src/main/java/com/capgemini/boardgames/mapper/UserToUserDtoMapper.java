package com.capgemini.boardgames.mapper;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoMapper {

    public UserDto map(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setMotto(user.getMotto());
        userDto.setAvailability(user.getAvailability());
        userDto.setUserLevel(user.getUserLevel());
        userDto.setRankingPosition(user.getRankingPosition());
        userDto.setGameHistory(user.getGameHistory());
        return userDto;
    }
}

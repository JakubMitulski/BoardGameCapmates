package com.capgemini.boardgames.mapper;

import com.capgemini.boardgames.dto.UserDto;
import com.capgemini.boardgames.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public UserDto map(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setMotto(user.getMotto());
        userDto.setPlayability(user.getPlayability());
        return userDto;
    }
}

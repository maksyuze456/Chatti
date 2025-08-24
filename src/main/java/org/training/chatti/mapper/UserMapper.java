package org.training.chatti.mapper;

import org.springframework.stereotype.Component;
import org.training.chatti.dto.UserDto;
import org.training.chatti.model.User;

@Component
public class UserMapper {



    public UserDto entityToDto(User user) {
        return new UserDto(user.getId(), user.getUsername());
    }

}

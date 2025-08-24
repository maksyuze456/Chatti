package org.training.chatti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.chatti.dto.UserDto;
import org.training.chatti.mapper.UserMapper;
import org.training.chatti.model.User;
import org.training.chatti.repository.UserRepository;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;



    public UserDto getUserDtoByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return userMapper.entityToDto(user);
    }
}

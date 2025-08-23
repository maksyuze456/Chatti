package org.training.chatti.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.training.chatti.dto.PostDetailsDto;
import org.training.chatti.dto.UserWithPostsDto;
import org.training.chatti.model.User;

import java.util.List;

@Component
public class UserMapper {

    @Autowired
    PostMapper postMapper;

    public UserWithPostsDto userToUserWithPostsDto(User user) {
        UserWithPostsDto userWithPostsDto = new UserWithPostsDto();

        userWithPostsDto.setId(user.getId());
        userWithPostsDto.setUsername(user.getUsername());

        List<PostDetailsDto> listOfPostsDto = user.getPosts().stream()
                .map(post -> {
                    return postMapper.findPostDetailsById(post.getId());
                })
                .toList();

        userWithPostsDto.setPosts(listOfPostsDto);

        return userWithPostsDto;
    }

}

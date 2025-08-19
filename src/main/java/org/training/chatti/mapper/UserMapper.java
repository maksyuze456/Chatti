package org.training.chatti.mapper;

import org.mapstruct.Mapper;
import org.training.chatti.dto.UserWithPostsDto;
import org.training.chatti.model.User;


@Mapper(componentModel = "spring",uses = PostMapper.class)
public interface UserMapper {


    UserWithPostsDto userToUserWithPostsDto(User user);

}

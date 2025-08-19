package org.training.chatti.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.training.chatti.dto.PostDetailsDto;
import org.training.chatti.model.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "userId", source = "post.user.id")
    PostDetailsDto postToPostDetailsDto(Post post);

}

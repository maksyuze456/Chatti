package org.training.chatti.mapper;

import org.springframework.stereotype.Component;
import org.training.chatti.dto.PostRequestDto;
import org.training.chatti.dto.PostResponseDto;
import org.training.chatti.model.Post;
import org.training.chatti.model.User;

import java.util.Collections;
import java.util.List;

@Component
public class PostMapper {



    public PostResponseDto entityToDto(Post post) {
        return new PostResponseDto(post.getId(), post.getUser().getId(), post.getTitle(), post.getContent(), post.getCreatedAt());
    }

    public List<PostResponseDto> entityListToDtoList(List<Post> posts) {
        return posts.stream()
                .map(this::entityToDto)
                .toList();
    }

    public Post dtoToEntity(PostRequestDto postRequestDto) {
        return new Post(new User(postRequestDto.userId()), Collections.emptyList(), postRequestDto.title(), postRequestDto.content(), postRequestDto.createdAt(), null);
    }

    public Post dtoResponseToEntity(PostResponseDto postResponseDto) {
        return new Post(postResponseDto.id(), new User(postResponseDto.userId()), postResponseDto.title(), postResponseDto.content(), postResponseDto.createdAt());
    }


}

package org.training.chatti.mapper;

import org.springframework.stereotype.Component;
import org.training.chatti.dto.PostDto;
import org.training.chatti.model.Post;

import java.util.List;

@Component
public class PostMapper {



    public PostDto entityToDto(Post post) {
        return new PostDto(post.getId(), post.getUser().getId(), post.getTitle(), post.getContent(), post.getCreatedAt());
    }

    public List<PostDto> entityListToDtoList(List<Post> posts) {
        return posts.stream()
                .map(this::entityToDto)
                .toList();
    }

}

package org.training.chatti.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.training.chatti.dto.PostDetailsDto;
import org.training.chatti.service.PostService;

@Component
public class PostMapper {

    @Autowired
    PostService postService;

    public PostDetailsDto findPostDetailsById(int postId) {
        return postService.findPostDetailsById(postId);
    }

}

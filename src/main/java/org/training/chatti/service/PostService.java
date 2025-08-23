package org.training.chatti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.chatti.dto.PostDetailsDto;
import org.training.chatti.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public PostDetailsDto findPostDetailsById(int postId) {
        return postRepository.findPostDetailsById(postId);
    }

}

package org.training.chatti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.chatti.dto.PostRequestDto;
import org.training.chatti.dto.PostResponseDto;
import org.training.chatti.mapper.PostMapper;
import org.training.chatti.model.Post;
import org.training.chatti.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostMapper postMapper;


    public List<Post> getAllPostsByUserId(int userId) {
        return postRepository.findPostsByUserId(userId);
    }

    public List<PostResponseDto> getAllPostsDtosByUserId(int userId) {
        List<Post> posts = getAllPostsByUserId(userId);
        return postMapper.entityListToDtoList(posts);
    }

    public PostResponseDto addPostToUserByUserId(PostRequestDto postRequestDto) {
        Post postToAdd = postMapper.dtoToEntity(postRequestDto);
        Post addedPost = postRepository.save(postToAdd);

        return postMapper.entityToDto(addedPost);
    }

    public PostResponseDto updatePost(PostResponseDto postResponseDto) {
        Post updatedPost = postRepository.save(postMapper.dtoResponseToEntity(postResponseDto));
        return postMapper.entityToDto(updatedPost);
    }


}

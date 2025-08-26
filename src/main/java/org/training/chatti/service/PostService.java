package org.training.chatti.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.chatti.dto.PostRequestDto;
import org.training.chatti.dto.PostResponseDto;
import org.training.chatti.mapper.PostMapper;
import org.training.chatti.model.Post;
import org.training.chatti.repository.PostRepository;

import java.util.List;
import java.util.Optional;

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

    public PostResponseDto updatePost(PostResponseDto postResponseDto){

        Optional<Post> fetchedPost = postRepository.findById(postResponseDto.id());
        if(fetchedPost.isEmpty()) {
            throw new RuntimeException("Post with such post id is not found");
        } else {
            Post post = fetchedPost.get();
            if (post.getUser().getId() != postResponseDto.userId()) {
                throw new RuntimeException("Post does not belong to a given user.");
            } else {
                Post updatedPost = postRepository.save(postMapper.dtoResponseToEntity(postResponseDto));
                return postMapper.entityToDto(updatedPost);
            }
        }
    }

    public boolean deletePost(int id, int userId) {

        if (!postRepository.existsByIdAndUserId(id, userId)) {
            throw new EntityNotFoundException("Post with such id does not exists, or does not belong to a given user.");
        } else {
            postRepository.deleteById(id);
            return true;
        }

    }


}

package org.training.chatti.mapper;

import org.springframework.stereotype.Component;
import org.training.chatti.dto.CommentRequestDto;
import org.training.chatti.dto.CommentResponseDto;
import org.training.chatti.model.Comment;
import org.training.chatti.model.Post;
import org.training.chatti.model.User;

import java.util.List;

@Component
public class CommentMapper {

    public CommentResponseDto entityToDto(Comment comment) {
        return new CommentResponseDto(comment.getId(), comment.getUser().getId(), comment.getPost().getId(), comment.getContent(), comment.getCreatedAt());
    }

    public List<CommentResponseDto> entityListToDto(List<Comment> commentList) {
        return commentList.stream()
                .map(this::entityToDto)
                .toList();
    }

    public Comment dtoRequestToEntity(CommentRequestDto commentRequestDto) {
        return new Comment(new Post(commentRequestDto.postId()), new User(commentRequestDto.userId()), commentRequestDto.content(), commentRequestDto.createdAt());
    }



}

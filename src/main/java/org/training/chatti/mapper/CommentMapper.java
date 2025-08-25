package org.training.chatti.mapper;

import org.springframework.stereotype.Component;
import org.training.chatti.dto.CommentDto;
import org.training.chatti.model.Comment;

import java.util.List;

@Component
public class CommentMapper {

    public CommentDto entityToDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getUser().getId(), comment.getPost().getId(), comment.getContent(), comment.getCreatedAt());
    }

    public List<CommentDto> entityListToDto(List<Comment> commentList) {
        return commentList.stream()
                .map(this::entityToDto)
                .toList();
    }


}

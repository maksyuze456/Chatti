package org.training.chatti.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.chatti.dto.CommentRequestDto;
import org.training.chatti.dto.CommentResponseDto;
import org.training.chatti.mapper.CommentMapper;
import org.training.chatti.model.Comment;
import org.training.chatti.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentMapper commentMapper;

    public List<Comment> getCommentsByPostId(int postId) {
        return commentRepository.findCommentsByPostId(postId);
    }

    public List<CommentResponseDto> getCommentsDtosByPostId(int postId) {
        return commentMapper.entityListToDto(getCommentsByPostId(postId));
    }

    public CommentResponseDto addComment(CommentRequestDto commentRequestDto) {
        Comment commentToAdd = commentMapper.dtoRequestToEntity(commentRequestDto);
        return commentMapper.entityToDto(commentRepository.save(commentToAdd));
    }

    public boolean deleteComment(int id, int userId) {
        if (!commentRepository.existsByIdAndUserId(id, userId)) {
            throw new EntityNotFoundException("Comment with such id does not exists, or does not belong to a given user.");
        } else {
            commentRepository.deleteById(id);
            return true;
        }
    }





}

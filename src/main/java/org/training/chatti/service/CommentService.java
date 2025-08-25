package org.training.chatti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.chatti.dto.CommentDto;
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

    public List<CommentDto> getCommentsDtosByPostId(int postId) {
        return commentMapper.entityListToDto(getCommentsByPostId(postId));
    }


}

package org.training.chatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.chatti.model.Comment;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findCommentsByPostId(int postId);

}

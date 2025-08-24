package org.training.chatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.chatti.model.Comment;


public interface CommentRepository extends JpaRepository<Comment, Integer> {



}

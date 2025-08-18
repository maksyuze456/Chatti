package org.training.chatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.chatti.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}

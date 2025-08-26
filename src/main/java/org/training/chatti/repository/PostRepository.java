package org.training.chatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.chatti.model.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {


    List<Post> findPostsByUserId(int userId);

    boolean existsByIdAndUserId(int id, int userId);

}

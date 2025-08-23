package org.training.chatti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.training.chatti.dto.PostDetailsDto;
import org.training.chatti.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select new org.training.chatti.dto.PostDetailsDto(" +
            "p.id, p.user.id, p.title, p.content, count(c)) " +
            "from Post p left join p.comments c " +
            "where p.id = :postId " +
            "group by p.id, p.user.id, p.title, p.content")
    PostDetailsDto findPostDetailsById(int postId);


}

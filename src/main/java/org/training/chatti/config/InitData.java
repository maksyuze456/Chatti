package org.training.chatti.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.training.chatti.model.Comment;
import org.training.chatti.model.Post;
import org.training.chatti.model.User;
import org.training.chatti.repository.CommentRepository;
import org.training.chatti.repository.PostRepository;
import org.training.chatti.repository.UserRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(Collections.emptyList(), Collections.emptyList(), "maksyuze456", "12345maksa");
        User u2 = new User(Collections.emptyList(), Collections.emptyList(), "gusemil654", "123gus");
        User u3 = new User(Collections.emptyList(), Collections.emptyList(), "danitri789", "1234dani");

        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        Post p1 = new Post(u1, Collections.emptyList(), "Hello world!", "Goodbye world! It was great to be here, but it's over for now!", LocalDate.now(), LocalDate.now());
        Post p2 = new Post(u2, Collections.emptyList(), "Hello Denmark!", "Goodbye Denmark! It was a great pleasure to be here!", LocalDate.now(), LocalDate.now());

        postRepository.save(p1);
        postRepository.save(p2);

        Comment c1 = new Comment(p1, u2, "Yo, where are you heading towards to?", LocalDate.now(), LocalDate.now());
        Comment c2 = new Comment(p2, u1, "You planning to travel to Sweden next?", LocalDate.now(), LocalDate.now());

        commentRepository.save(c1);
        commentRepository.save(c2);



    }
}

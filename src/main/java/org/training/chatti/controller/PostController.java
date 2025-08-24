package org.training.chatti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.chatti.service.PostService;

@RequestMapping("/posts")
@RestController
public class PostController {

    @Autowired
    PostService postService;


    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllPostsByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(postService.getAllPostsDtosByUserId(userId));
    }

}

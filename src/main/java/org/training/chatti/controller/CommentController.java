package org.training.chatti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.chatti.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/all/{postId}")
    public ResponseEntity<?> getCommentsByPostId(@PathVariable int postId) {
        return ResponseEntity.ok(commentService.getCommentsDtosByPostId(postId));
    }


}

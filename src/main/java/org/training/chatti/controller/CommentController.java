package org.training.chatti.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.chatti.dto.CommentRequestDto;
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

    @PostMapping("/add")
    public ResponseEntity<?> addComment(@RequestBody CommentRequestDto commentRequestDto) {
        return ResponseEntity.ok(commentService.addComment(commentRequestDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteComment(@RequestParam int id, @RequestParam int userId) {
        try {
            boolean deleted = commentService.deleteComment(id, userId);
            if(deleted){
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to delete comment", HttpStatus.BAD_REQUEST);
            }
        } catch(EntityNotFoundException e) {
            return new ResponseEntity<>("Comment with such id does not exists, or does not belong to a given user.", HttpStatus.NOT_FOUND);
        }
    }

}

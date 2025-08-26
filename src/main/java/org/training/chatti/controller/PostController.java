package org.training.chatti.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.chatti.dto.PostRequestDto;
import org.training.chatti.dto.PostResponseDto;
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

    @PostMapping("/add")
    public ResponseEntity<?> addPostToUserByUserId(@RequestBody PostRequestDto postRequestDto) {
        return new ResponseEntity<>(postService.addPostToUserByUserId(postRequestDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePost(@RequestBody PostResponseDto postResponseDto) {

        try{
            PostResponseDto updatedPost = postService.updatePost(postResponseDto);
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Post does not exist, or does not belong to the given user", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deletePost(@RequestParam("id") int id, @RequestParam("userId") int userId) {
        try {
            boolean deleted = postService.deletePost(id, userId);
            if(deleted){
                return new ResponseEntity<>("Deleted", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to delete post", HttpStatus.BAD_REQUEST);
            }
        } catch(EntityNotFoundException e) {
            return new ResponseEntity<>("Post with such id does not exists, or does not belong to a given user.", HttpStatus.NOT_FOUND);
        }
    }
}

package org.training.chatti.controller;

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
        return new ResponseEntity<>(postService.updatePost(postResponseDto), HttpStatus.OK);
    }


}

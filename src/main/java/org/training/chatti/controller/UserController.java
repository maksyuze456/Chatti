package org.training.chatti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.chatti.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserWithPostsByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserDtoByUsername(username));
    }

}

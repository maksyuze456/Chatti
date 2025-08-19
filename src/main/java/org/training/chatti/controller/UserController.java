package org.training.chatti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.chatti.service.UserService;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<?> getUserWithPostsByUsername(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        return ResponseEntity.ok(userService.findUserWithPostsByUsername(username));
    }

}

package com.chess_sfml.chess.controller;

import com.chess_sfml.chess.dto.UserDto;
import com.chess_sfml.chess.entity.User;
import com.chess_sfml.chess.exception.NotFoundException;
import com.chess_sfml.chess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        User user = userService.findById(userId).orElseThrow();
        return ResponseEntity.ok(new UserDto(user));
    }
}

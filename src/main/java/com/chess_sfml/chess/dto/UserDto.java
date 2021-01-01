package com.chess_sfml.chess.dto;

import com.chess_sfml.chess.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String firstName;
    private String lastName;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}

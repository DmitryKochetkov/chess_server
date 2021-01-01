package com.chess_sfml.chess.dto;

import com.chess_sfml.chess.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserDtoTests {
    private User user;

    @Before
    public void setup() {
        user = new User();
        user = new User();
        user.setUsername("best_user");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setPassword("i_dont_use_hashing");
    }

    @Test
    public void testUserDto() {
        UserDto userDto = new UserDto(user);
        assertEquals("best_user", userDto.getUsername());
        assertEquals("Ivan", userDto.getFirstName());
        assertEquals("Ivanov", userDto.getLastName());
    }
}

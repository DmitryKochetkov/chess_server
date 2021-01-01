package com.chess_sfml.chess.service;

import com.chess_sfml.chess.entity.User;
import com.chess_sfml.chess.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {
    @Autowired
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @Before
    public void setup() {
        testUser = new User();
        testUser.setUsername("best_user");
        testUser.setFirstName("Ivan");
        testUser.setLastName("Ivanov");
        testUser.setPassword("i_dont_use_hashing");
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(testUser));
    }

    @Test
    public void testFindById() {
        assertEquals(testUser, userService.findById(1L).orElseThrow());
    }
}

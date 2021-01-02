package com.chess_sfml.chess.controller;

import com.chess_sfml.chess.entity.User;
import com.chess_sfml.chess.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userServiceMock;

    @BeforeAll
    public void setup() {
        User user = new User();
        user.setUsername("best_user");
        user.setFirstName("Ivan");
        user.setLastName("Ivanov");
        user.setPassword("i_dont_use_hashing");
        when(userServiceMock.findById(1L)).thenReturn(java.util.Optional.of(user));
    }

    @Test
    public void getUserByExistingId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/{userId}", 1L))
                .andExpect(status().isOk());
    }

    @Test
    public void getUserByNotExistingId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/{userId}", 2L))
                .andExpect(status().isNotFound());
    }
}

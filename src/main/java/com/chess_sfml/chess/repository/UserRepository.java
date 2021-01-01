package com.chess_sfml.chess.repository;

import com.chess_sfml.chess.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

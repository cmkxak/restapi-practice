package com.likelion.restapipractice.repository;

import com.likelion.restapipractice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameContains(String username);
}

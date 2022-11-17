package com.likelion.restapipractice.repository;

import com.likelion.restapipractice.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

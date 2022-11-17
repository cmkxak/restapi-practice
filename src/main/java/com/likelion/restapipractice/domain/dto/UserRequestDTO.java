package com.likelion.restapipractice.domain.dto;

import com.likelion.restapipractice.domain.entity.User;

public class UserRequestDTO {
    private String username;
    private String password;

    public User toEntity() {
        return new User(this.username, this.password);
    }
}

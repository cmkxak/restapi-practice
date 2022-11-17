package com.likelion.restapipractice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponseDTO {
    private Long id;
    private String username;
    private String message;

    public UserResponseDTO(String username, String message) {
        this.username = username;
        this.message = message;
    }
}

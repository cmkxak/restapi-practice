package com.likelion.restapipractice.controller;

import com.likelion.restapipractice.domain.dto.UserRequestDTO;
import com.likelion.restapipractice.domain.dto.UserResponseDTO;
import com.likelion.restapipractice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("api/v1/users")
@RestController
public class UserRestController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id){
        UserResponseDTO userResponseDTO = userService.findById(id);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.save(userRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }
}

package com.likelion.restapipractice.service;

import com.likelion.restapipractice.domain.dto.UserRequestDTO;
import com.likelion.restapipractice.domain.dto.UserResponseDTO;
import com.likelion.restapipractice.domain.entity.User;
import com.likelion.restapipractice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO findById(Long id){
        Optional<User> optUser = userRepository.findById(id);
        if(optUser.isEmpty()){
            return new UserResponseDTO(id, "", "해당 id의 유저가 없습니다.");
        }
        User user = optUser.get();
        return new UserResponseDTO(user.getId(), user.getUsername(), "");
    }

    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        Optional<User> selectedUserByUserName = userRepository.findByUsernameContains(userRequestDTO.getUsername());

        if(!selectedUserByUserName.isEmpty()){
            return new UserResponseDTO(selectedUserByUserName.get().getUsername(), "해당 id는 중복입니다.");
        }

        User savedUser = userRepository.save(userRequestDTO.toEntity());
        return new UserResponseDTO(savedUser.getId(), savedUser.getUsername(), "가입이 완료되었습니다.");
    }
}

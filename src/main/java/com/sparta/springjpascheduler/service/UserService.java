package com.sparta.springjpascheduler.service;

import com.sparta.springjpascheduler.dto.UserRequestDto;
import com.sparta.springjpascheduler.dto.UserResponseDto;
import com.sparta.springjpascheduler.entity.User;
import com.sparta.springjpascheduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setUserName(userRequestDto.getUserName());
        user.setEmail(userRequestDto.getEmail());

        return mapToUserResponseDto(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToUserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToUserResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userRequestDto.getUserName() != null && !userRequestDto.getUserName().isEmpty()) {
            user.setUserName(userRequestDto.getUserName());
        }

        if (userRequestDto.getEmail() != null && !userRequestDto.getEmail().isEmpty()) {
            user.setEmail(userRequestDto.getEmail());
        }

        return mapToUserResponseDto(userRepository.save(user));
    }

    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    private UserResponseDto mapToUserResponseDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }
}
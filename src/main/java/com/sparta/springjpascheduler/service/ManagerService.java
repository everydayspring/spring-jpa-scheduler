package com.sparta.springjpascheduler.service;

import com.sparta.springjpascheduler.dto.ManagerRequestDto;
import com.sparta.springjpascheduler.dto.ManagerResponseDto;
import com.sparta.springjpascheduler.dto.ManagerUpdateRequestDto;
import com.sparta.springjpascheduler.entity.Manager;
import com.sparta.springjpascheduler.entity.Todo;
import com.sparta.springjpascheduler.entity.User;
import com.sparta.springjpascheduler.repository.ManagerRepository;
import com.sparta.springjpascheduler.repository.TodoRepository;
import com.sparta.springjpascheduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Transactional
    public ManagerResponseDto saveManager(ManagerRequestDto managerRequestDto) {
        Todo todo = todoRepository.findById(managerRequestDto.getTodoId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        User user = userRepository.findById(managerRequestDto.getTodoUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        User managerUser = userRepository.findById(managerRequestDto.getManagerUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!Objects.equals(todo.getUser().getId(), managerRequestDto.getTodoUserId())) {
            throw new RuntimeException("올바른 작성자가 아닙니다");
        }

        if (managerRepository.existsByTodoIdAndUserId(todo.getUser().getId(), managerRequestDto.getManagerUserId())) {
            throw new RuntimeException("작성자는 담당자가 될 수 없습니다");
        }

        Manager manager = new Manager(managerUser, todo);

        return mapToResponseDto(managerRepository.save(manager));
    }

    public List<ManagerResponseDto> getAllManagers() {
        return managerRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    public ManagerResponseDto getManagerById(Long id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        return mapToResponseDto(manager);
    }

    @Transactional
    public ManagerResponseDto updateManager(Long id, ManagerUpdateRequestDto managerRequestDto) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));

        Todo todo = manager.getTodo();
        if (managerRepository.existsByTodoIdAndUserId(todo.getUser().getId(), managerRequestDto.getUserId())) {
            throw new RuntimeException("작성자는 담당자가 될 수 없습니다");
        }

        User managerUser = userRepository.findById(managerRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        manager.update(managerUser);

        return mapToResponseDto(managerRepository.save(manager));
    }

    @Transactional
    public void deleteManager(Long id) {
        if (!managerRepository.existsById(id)) {
            throw new RuntimeException("Manager not found");
        }
        managerRepository.deleteById(id);
    }

    private ManagerResponseDto mapToResponseDto(Manager manager) {
        return new ManagerResponseDto(
                manager.getId(),
                manager.getUser().getId(),
                manager.getTodo().getId()
        );
    }
}

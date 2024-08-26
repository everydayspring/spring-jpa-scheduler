package com.sparta.springjpascheduler.service;

import com.sparta.springjpascheduler.dto.TodoRequestDto;
import com.sparta.springjpascheduler.dto.TodoResponseDto;
import com.sparta.springjpascheduler.entity.Todo;
import com.sparta.springjpascheduler.repository.TodoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public TodoResponseDto saveTodo(TodoRequestDto request) {
        Todo todo = new Todo();
        todo.setUserName(request.getUserName());
        todo.setTitle(request.getTitle());
        todo.setContent(request.getContent());
        Todo savedTodo = todoRepository.save(todo);

        return mapToResponseDto(savedTodo);
    }

    @Transactional(readOnly = true)
    public Optional<TodoResponseDto> getTodoById(Long id) {
        return todoRepository.findById(id).map(this::mapToResponseDto);
    }

    @Transactional
    public TodoResponseDto updateTodo(Long id, TodoRequestDto request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setUserName(request.getUserName());
        todo.setTitle(request.getTitle());
        todo.setContent(request.getContent());
        Todo updatedTodo = todoRepository.save(todo);

        return mapToResponseDto(updatedTodo);
    }

    private TodoResponseDto mapToResponseDto(Todo todo) {
        TodoResponseDto dto = new TodoResponseDto();
        dto.setId(todo.getId());
        dto.setUserName(todo.getUserName());
        dto.setTitle(todo.getTitle());
        dto.setContent(todo.getContent());
        dto.setCreatedAt(todo.getCreatedAt());
        dto.setUpdatedAt(todo.getUpdatedAt());
        return dto;
    }
}
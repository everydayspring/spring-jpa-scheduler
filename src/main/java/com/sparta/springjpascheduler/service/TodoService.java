package com.sparta.springjpascheduler.service;

import com.sparta.springjpascheduler.dto.TodoRequestDto;
import com.sparta.springjpascheduler.dto.TodoResponseDto;
import com.sparta.springjpascheduler.entity.Todo;
import com.sparta.springjpascheduler.repository.CommentRepository;
import com.sparta.springjpascheduler.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public TodoResponseDto saveTodo(TodoRequestDto todoRequestDto) {
        Todo todo = new Todo();
        todo.setUserName(todoRequestDto.getUserName());
        todo.setTitle(todoRequestDto.getTitle());
        todo.setContent(todoRequestDto.getContent());

        return mapToResponseDto(todoRepository.save(todo));
    }

    @Transactional(readOnly = true)
    public Optional<TodoResponseDto> getTodoById(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo not found");
        }

        return todoRepository.findById(id).map(this::mapToResponseDto);
    }

    @Transactional
    public TodoResponseDto updateTodo(Long id, TodoRequestDto todoRequestDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setUserName(todoRequestDto.getUserName());
        todo.setTitle(todoRequestDto.getTitle());
        todo.setContent(todoRequestDto.getContent());
        Todo updatedTodo = todoRepository.save(todo);

        return mapToResponseDto(updatedTodo);
    }

    @Transactional(readOnly = true)
    public Page<TodoResponseDto> getTodos(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "modifiedAt");
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Todo> todoList = todoRepository.findAll(pageable);
        return todoList.map(this::mapToResponseDto);
    }

    @Transactional
    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new RuntimeException("Todo not found");
        }
        todoRepository.deleteById(id);
    }

    private TodoResponseDto mapToResponseDto(Todo todo) {

        return new TodoResponseDto(
                todo.getId(),
                todo.getUserName(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreatedAt(),
                todo.getModifiedAt(),
                commentRepository.countByTodoId(todo.getId())
        );
    }
}
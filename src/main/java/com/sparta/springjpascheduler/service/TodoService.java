package com.sparta.springjpascheduler.service;

import com.sparta.springjpascheduler.dto.TodoRequestDto;
import com.sparta.springjpascheduler.dto.TodoResponseDto;
import com.sparta.springjpascheduler.entity.Todo;
import com.sparta.springjpascheduler.repository.CommentRepository;
import com.sparta.springjpascheduler.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private CommentRepository commentRepository;

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

    public Page<TodoResponseDto> getTodos(int page, int size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updatedAt");
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Todo> todoList = todoRepository.findAll(pageable);
        return todoList.map(this::mapToResponseDto);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    private TodoResponseDto mapToResponseDto(Todo todo) {
        TodoResponseDto dto = new TodoResponseDto();
        dto.setId(todo.getId());
        dto.setUserName(todo.getUserName());
        dto.setTitle(todo.getTitle());
        dto.setContent(todo.getContent());
        dto.setCreatedAt(todo.getCreatedAt());
        dto.setUpdatedAt(todo.getUpdatedAt());

        int commentCnt = commentRepository.countByTodoId(todo.getId());
        dto.setCommentCnt(commentCnt);

        return dto;
    }
}
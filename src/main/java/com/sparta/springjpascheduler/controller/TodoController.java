package com.sparta.springjpascheduler.controller;

import com.sparta.springjpascheduler.dto.TodoRequestDto;
import com.sparta.springjpascheduler.dto.TodoResponseDto;
import com.sparta.springjpascheduler.entity.Todo;
import com.sparta.springjpascheduler.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto request) {
        return todoService.saveTodo(request);
    }

    @GetMapping("/{id}")
    public TodoResponseDto getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    @PutMapping("/{id}")
    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto request) {
        return todoService.updateTodo(id, request);
    }
}
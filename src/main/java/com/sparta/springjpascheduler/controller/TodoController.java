package com.sparta.springjpascheduler.controller;

import com.sparta.springjpascheduler.dto.TodoRequestDto;
import com.sparta.springjpascheduler.dto.TodoResponseDto;
import com.sparta.springjpascheduler.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        return todoService.saveTodo(todoRequestDto);
    }

    @GetMapping("/{id}")
    public TodoResponseDto getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    @PutMapping("/{id}")
    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.updateTodo(id, todoRequestDto);
    }

    @GetMapping
    public Page<TodoResponseDto> getTodos(@RequestParam int page, @RequestParam int size) {
        return todoService.getTodos(page - 1, size);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
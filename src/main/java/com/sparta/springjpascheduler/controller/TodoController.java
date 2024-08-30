package com.sparta.springjpascheduler.controller;

import com.sparta.springjpascheduler.dto.TodoRequestDto;
import com.sparta.springjpascheduler.dto.TodoResponseDto;
import com.sparta.springjpascheduler.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    /**
     * 일정 등록
     * @body todoRequestDto
     * @return TodoResponseDto
     */
    @PostMapping
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto todoRequestDto) {
        return todoService.saveTodo(todoRequestDto);
    }

    /**
     * 일정 단건 조회
     * @param id
     * @return TodoResponseDto
     */
    @GetMapping("/{id}")
    public TodoResponseDto getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    /**
     * 일정 수정
     * @param id
     * @body todoRequestDto
     * @return TodoResponseDto
     */
    @PutMapping("/{id}")
    public TodoResponseDto updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.updateTodo(id, todoRequestDto);
    }

    /**
     * 일정 전체 조회
     * @query page, size
     * @return Page<TodoResponseDto>
     */
    @GetMapping
    public Page<TodoResponseDto> getTodos(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return todoService.getTodos(page - 1, size);
    }

    /**
     * 일정 삭제
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
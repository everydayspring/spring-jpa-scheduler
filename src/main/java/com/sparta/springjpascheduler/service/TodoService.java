package com.sparta.springjpascheduler.service;

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

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setTitle(updatedTodo.getTitle());
        todo.setContent(updatedTodo.getContent());
        return todoRepository.save(todo);
    }
}

package com.sparta.springjpascheduler.repository;

import com.sparta.springjpascheduler.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

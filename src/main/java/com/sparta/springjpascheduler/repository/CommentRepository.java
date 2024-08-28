package com.sparta.springjpascheduler.repository;

import com.sparta.springjpascheduler.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    int countByTodoId(Long todoId);
}
package com.sparta.springjpascheduler.repository;

import com.sparta.springjpascheduler.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTodoId(Long todoId);
}
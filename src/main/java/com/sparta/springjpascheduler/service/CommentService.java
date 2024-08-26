package com.sparta.springjpascheduler.service;

import com.sparta.springjpascheduler.dto.CommentRequestDto;
import com.sparta.springjpascheduler.dto.CommentResponseDto;
import com.sparta.springjpascheduler.entity.Comment;
import com.sparta.springjpascheduler.entity.Todo;
import com.sparta.springjpascheduler.repository.CommentRepository;
import com.sparta.springjpascheduler.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public CommentResponseDto saveComment(CommentRequestDto request) {
        Todo todo = todoRepository.findById(request.getTodoId())
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        Comment comment = new Comment();
        comment.setUserName(todo.getUserName());
        comment.setContent(request.getContent());
        comment.setTodo(todo);

        Comment savedComment = commentRepository.save(comment);
        return mapToResponseDto(savedComment);
    }

    @Transactional(readOnly = true)
    public Optional<CommentResponseDto> getCommentById(Long id) {
        return commentRepository.findById(id).map(this::mapToResponseDto);
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDto> getAllComments() {
        return commentRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.setContent(request.getContent());
        Comment updatedComment = commentRepository.save(comment);

        return mapToResponseDto(updatedComment);
    }

    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    private CommentResponseDto mapToResponseDto(Comment comment) {
        CommentResponseDto dto = new CommentResponseDto();
        dto.setId(comment.getId());
        dto.setTodoId(comment.getTodo().getId());
        dto.setUserName(comment.getUserName());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        return dto;
    }
}
package com.sparta.springjpascheduler.service;

import com.sparta.springjpascheduler.dto.CommentRequestDto;
import com.sparta.springjpascheduler.dto.CommentResponseDto;
import com.sparta.springjpascheduler.dto.UserResponseDto;
import com.sparta.springjpascheduler.entity.Comment;
import com.sparta.springjpascheduler.entity.Todo;
import com.sparta.springjpascheduler.entity.User;
import com.sparta.springjpascheduler.repository.CommentRepository;
import com.sparta.springjpascheduler.repository.TodoRepository;
import com.sparta.springjpascheduler.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponseDto saveComment(CommentRequestDto commentRequestDto) {
        Todo todo = todoRepository.findById(commentRequestDto.getTodoId())
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        User user = userRepository.findById(commentRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        Comment comment = new Comment(user, commentRequestDto.getContent(), todo);

        Comment savedComment = commentRepository.save(comment);
        return mapToResponseDto(savedComment);
    }

    @Transactional(readOnly = true)
    public Optional<CommentResponseDto> getCommentById(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new RuntimeException("Comment not found");
        }

        return commentRepository.findById(id).map(this::mapToResponseDto);
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDto> getAllComments() {
        return commentRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.setContent(commentRequestDto.getContent());
        Comment updatedComment = commentRepository.save(comment);

        return mapToResponseDto(updatedComment);
    }

    @Transactional
    public void deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new RuntimeException("Comment not found");
        }
        commentRepository.deleteById(id);
    }

    private CommentResponseDto mapToResponseDto(Comment comment) {
 return new CommentResponseDto(
                comment.getId(),
                comment.getTodo().getId(),
                comment.getUser().getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
        );
    }
}
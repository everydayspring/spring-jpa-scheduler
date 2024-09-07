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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponseDto saveComment(CommentRequestDto commentRequestDto) {
        Todo todo = todoRepository.findById(commentRequestDto.getTodoId())
                .orElseThrow(() -> new NoSuchElementException("Todo not found"));

        User user = userRepository.findById(commentRequestDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("Comment not found"));

        Comment comment = new Comment(user, commentRequestDto.getContent(), todo);

        Comment savedComment = commentRepository.save(comment);
        return mapToResponseDto(savedComment);
    }

    public Optional<CommentResponseDto> getCommentById(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new NoSuchElementException("Comment not found");
        }

        return commentRepository.findById(id).map(this::mapToResponseDto);
    }

    public List<CommentResponseDto> getAllComments() {
        return commentRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Comment not found"));

        comment.update(commentRequestDto.getContent());
        Comment updatedComment = commentRepository.save(comment);

        return mapToResponseDto(updatedComment);
    }

    @Transactional
    public void deleteComment(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new NoSuchElementException("Comment not found");
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
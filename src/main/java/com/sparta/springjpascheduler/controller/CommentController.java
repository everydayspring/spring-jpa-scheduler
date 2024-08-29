package com.sparta.springjpascheduler.controller;

import com.sparta.springjpascheduler.dto.CommentRequestDto;
import com.sparta.springjpascheduler.dto.CommentResponseDto;
import com.sparta.springjpascheduler.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public CommentResponseDto createComment(@RequestBody CommentRequestDto commentRequestDto) {
        return commentService.saveComment(commentRequestDto);
    }

    @GetMapping("/{id}")
    public CommentResponseDto getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @GetMapping
    public List<CommentResponseDto> getAllComments() {
        return commentService.getAllComments();
    }

    @PutMapping("/{id}")
    public CommentResponseDto updateComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto) {
        return commentService.updateComment(id, commentRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
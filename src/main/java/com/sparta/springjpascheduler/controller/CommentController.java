package com.sparta.springjpascheduler.controller;

import com.sparta.springjpascheduler.dto.CommentRequestDto;
import com.sparta.springjpascheduler.dto.CommentResponseDto;
import com.sparta.springjpascheduler.entity.Comment;
import com.sparta.springjpascheduler.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommentResponseDto createComment(@RequestBody CommentRequestDto request) {
        return commentService.saveComment(request);
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
    public CommentResponseDto updateComment(@PathVariable Long id, @RequestBody CommentRequestDto request) {
        return commentService.updateComment(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
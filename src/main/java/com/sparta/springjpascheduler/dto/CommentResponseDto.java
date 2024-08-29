package com.sparta.springjpascheduler.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private final Long id;
    private final Long todoId;
    private final String userName;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CommentResponseDto(Long id, Long todoId, String userName, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.todoId = todoId;
        this.userName = userName;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

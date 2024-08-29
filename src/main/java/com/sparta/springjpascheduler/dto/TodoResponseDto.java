package com.sparta.springjpascheduler.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {
    private final Long id;
    private final String userName;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final int commentCnt;

    public TodoResponseDto(Long id, String userName, String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt, int commentCnt) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.commentCnt = commentCnt;
    }
}

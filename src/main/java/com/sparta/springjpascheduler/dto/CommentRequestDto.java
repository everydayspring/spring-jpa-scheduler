package com.sparta.springjpascheduler.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long userId;
    private String content;
    private Long todoId;
}
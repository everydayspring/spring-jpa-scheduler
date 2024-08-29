package com.sparta.springjpascheduler.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String userName;
    private String content;
    private Long todoId;
}
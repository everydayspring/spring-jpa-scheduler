package com.sparta.springjpascheduler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private Long userId;
    private String content;
    private Long todoId;
}
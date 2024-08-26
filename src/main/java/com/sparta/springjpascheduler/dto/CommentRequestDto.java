package com.sparta.springjpascheduler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private String userName;
    private String content;
    private Long todoId;
}
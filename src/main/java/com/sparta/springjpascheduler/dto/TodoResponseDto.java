package com.sparta.springjpascheduler.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoResponseDto {
    private Long id;
    private String userName;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int commentCnt;
}

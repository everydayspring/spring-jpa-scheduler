package com.sparta.springjpascheduler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoRequestDto {
    private Long userId;
    private String title;
    private String content;
}

package com.sparta.springjpascheduler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequestDto {
    private String userName;
    private String title;
    private String content;
}

package com.sparta.springjpascheduler.dto;

import lombok.Getter;

@Getter
public class ManagerResponseDto {
    private final Long id;
    private final Long userId;
    private final Long todoId;

    public ManagerResponseDto(Long id, Long userId, Long todoId) {
        this.id = id;
        this.userId = userId;
        this.todoId = todoId;
    }
}

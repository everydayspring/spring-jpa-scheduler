package com.sparta.springjpascheduler.dto;

import lombok.Getter;

@Getter
public class ManagerUpdateRequestDto {
    private final Long userId;

    public ManagerUpdateRequestDto(Long userId) {
        this.userId = userId;
    }
}

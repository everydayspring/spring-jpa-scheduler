package com.sparta.springjpascheduler.dto;

import lombok.Getter;

@Getter
public class ManagerRequestDto {
    private Long todoId;
    private Long todoUserId;
    private Long managerUserId;
}

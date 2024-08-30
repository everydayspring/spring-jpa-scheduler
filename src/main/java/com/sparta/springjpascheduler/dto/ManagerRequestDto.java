package com.sparta.springjpascheduler.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ManagerRequestDto {
    private Long todoId;
    private Long todoUserId;
    private Long managerUserId;
}

package com.sparta.springjpascheduler.controller;

import com.sparta.springjpascheduler.dto.ManagerRequestDto;
import com.sparta.springjpascheduler.dto.ManagerResponseDto;
import com.sparta.springjpascheduler.dto.ManagerUpdateRequestDto;
import com.sparta.springjpascheduler.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping
    public ManagerResponseDto saveManager(@RequestBody ManagerRequestDto managerRequestDto) {
        return managerService.saveManager(managerRequestDto);
    }

    @GetMapping
    public List<ManagerResponseDto> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public ManagerResponseDto getManagerById(@PathVariable Long id) {
        return managerService.getManagerById(id);
    }

    @PutMapping("/{id}")
    public ManagerResponseDto updateManager(@PathVariable Long id, @RequestBody ManagerUpdateRequestDto managerRequestDto) {
        return managerService.updateManager(id, managerRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
    }

}

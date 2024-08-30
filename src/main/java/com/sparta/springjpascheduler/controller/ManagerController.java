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

    /**
     * 담당자 등록
     * @body managerRequestDto
     * @return ManagerResponseDto
     */
    @PostMapping
    public ManagerResponseDto saveManager(@RequestBody ManagerRequestDto managerRequestDto) {
        return managerService.saveManager(managerRequestDto);
    }

    /**
     * 담당자 전체 조회
     * @return List<ManagerResponseDto>
     */
    @GetMapping
    public List<ManagerResponseDto> getAllManagers() {
        return managerService.getAllManagers();
    }

    /**
     * 담당자 단건 조회
     * @param id
     * @return ManagerResponseDto
     */
    @GetMapping("/{id}")
    public ManagerResponseDto getManagerById(@PathVariable Long id) {
        return managerService.getManagerById(id);
    }

    /**
     * 담당자 수정
     * @param id
     * @body managerRequestDto
     * @return ManagerResponseDto
     */
    @PutMapping("/{id}")
    public ManagerResponseDto updateManager(@PathVariable Long id, @RequestBody ManagerUpdateRequestDto managerRequestDto) {
        return managerService.updateManager(id, managerRequestDto);
    }

    /**
     * 담당자 삭제
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
    }
}

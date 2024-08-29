package com.sparta.springjpascheduler.repository;

import com.sparta.springjpascheduler.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
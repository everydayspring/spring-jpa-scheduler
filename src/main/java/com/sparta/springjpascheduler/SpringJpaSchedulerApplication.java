package com.sparta.springjpascheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringJpaSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaSchedulerApplication.class, args);
    }

}
